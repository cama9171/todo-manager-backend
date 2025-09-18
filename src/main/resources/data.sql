INSERT INTO users (username, password)
    VALUES ('doe', '$2a$12$jK1bZQdd7KF6BnRpg1HhcuiJMeLpCnM5g8RicQarKSOmDqke3pYAC'),
           ('bob', '$2a$12$Jf78rbaqfH6bqbxX0PRXhea.kgvp1kBw4owsQ/bZna.vgDjnk4UJS'),
           ('mark', '$2a$12$4DED8k3ijS8yZ8ge/yFk1OogFSi5WlTKgrY0MKMf5aaFFCP9sD9im'),
           ('john', '$2a$12$UMCydEgBFsFttHybvokA1u17G2TO/VZQ6RAJk2F/9.fj4x.MyDiWG');

INSERT INTO tasks (title, status, user_id)
    VALUES ('Do homework', false, 2),
           ('Read newspaper', true, 3),
           ('Cooking', true, 1),
           ('Cleaning', false, 2);

-- SELECT TITLE, STATUS FROM TASKS INNER JOIN USERS ON TASKS.USER_ID = USERS.ID WHERE USER_ID = 2;
