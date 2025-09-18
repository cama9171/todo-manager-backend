INSERT INTO users (user_name, password)
    VALUES ('doe', 'pass123'),
           ('bob', 'pass456'),
           ('mark', 'pass789'),
           ('john', 'pass147');

INSERT INTO tasks (title, status, user_id)
    VALUES ('Do homework', false, 2),
           ('Read newspaper', true, 3),
           ('Cooking', true, 1),
           ('Cleaning', false, 2);

-- SELECT TITLE, STATUS FROM TASKS INNER JOIN USERS ON TASKS.USER_ID = USERS.ID WHERE USER_ID = 2;
