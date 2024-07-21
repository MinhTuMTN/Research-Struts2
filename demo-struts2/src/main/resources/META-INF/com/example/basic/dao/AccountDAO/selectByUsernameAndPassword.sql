SELECT
    /*%expand*/*
FROM
    account
WHERE
    username = /*username*/'test'
  AND
    password = /*password*/'test'