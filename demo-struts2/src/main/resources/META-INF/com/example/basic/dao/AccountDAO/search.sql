SELECT
    /*%expand*/*
FROM
    account
WHERE
    username LIKE CONCAT('%', /*username*/'test', '%')