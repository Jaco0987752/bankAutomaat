<?php

require 'config.php';

$pdo = new PDO('mysql:host=localhost;dbname=' . $dbName, $dbUserName, $dbPassword, [
    PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
    PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_OBJ,
    PDO::ATTR_EMULATE_PREPARES => false
]);

$query = $pdo->query("SELECT * FROM bankaccounts ");
$list = $query->fetchAll();

foreach ($list as $item) {
    echo  'name = ' . $item->name . " balance = ";
    echo $item->balance . "</br>";
}