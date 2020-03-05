<?php

require 'config.php';

$pdo = new PDO('mysql:host=localhost;dbname=' . $dbName, $dbUserName, $dbPassword, [
    PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
    PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_OBJ,
    PDO::ATTR_EMULATE_PREPARES => false
]);

function getParameter(string $str)
{
    if (isset($_GET[$str]) && $_GET[$str] != null) {
        return htmlspecialchars_decode($_GET[$str], ENT_QUOTES);
    }
    return null;
}














echo json_encode($objectToSend);
#end