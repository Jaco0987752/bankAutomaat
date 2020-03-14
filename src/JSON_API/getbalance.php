<?php
// https://www.php.net/manual/en/book.pdo.php

require 'config.php';

$pdo = new PDO('mysql:host=localhost;dbname=' . $dbName, $dbUserName, $dbPassword, [
    PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
    PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_OBJ,
    PDO::ATTR_EMULATE_PREPARES => false
]);

function getParameter(string $str)
{
    if (isset($_POST[$str]) && $_POST[$str] != null) {
        return htmlspecialchars_decode($_POST[$str], ENT_QUOTES);
    }
    return null;
}

//echo getParameter("cartnumber") ." ".  getParameter("pin");

$sth = $pdo->prepare('SELECT id, accountname, balance FROM bankaccounts WHERE cartNumber = ? AND pin = ?');
$sth->execute(array((int)getParameter("cartnumber"), (int)getParameter("pin")));

echo json_encode($sth->fetchObject());