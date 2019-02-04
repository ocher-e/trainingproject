INSERT INTO t_timetable
        (F_TIMETABLE_ID, F_COUNT_OF_ROOMS, F_PAIRS_IN_DAY, F_WORK_DAYS_IN_WEEK)
VALUES (NULL, 5, 3, 5);

INSERT INTO t_user
        (F_USER_ID, F_LOGIN, F_NAME, F_PASSWORD, F_TIMETABLE_ID)
VALUES (NULL, "admin", "Admin", "1234", 1),
       (NULL, "prof1", "Prof1", "1111", 1),
       (NULL, "prof2", "Prof2", "2222", 1),
       (NULL, "prof3", "Prof3", "3333", 1),
       (NULL, "prof4", "Prof4", "4444", 1),
       (NULL, "prof5", "Prof5", "5555", 1),
       (NULL, "prof6", "Prof6", "6666", 1),
       (NULL, "prof7", "Prof7", "7777", 1);

INSERT INTO t_admin VALUES(1);

INSERT INTO t_professor VALUES(2), (3), (4), (5), (6), (7), (8);

INSERT INTO t_request
       (F_REQUEST_ID, F_DISCIPLINE, F_PAIRS_IN_WEEK, F_GROUP, F_USER_ID)
VALUES (null, "Math", 3, 1, 2),
       (null, "Math", 3, 2, 2),
       (null, "Phis", 2, 1, 2),
       (null, "Mater", 3, 1, 3),
       (null, "Mech", 3, 1, 3),
       (null, "Lang", 2, 1, 4),
       (null, "Lang", 2, 2, 4),
       (null, "Econ", 3, 2, 5),
       (null, "Accou", 3, 2, 5),
       (null, "Socio", 2, 2, 6),
       (null, "Manag", 2, 2, 7),
       (null, "Graph", 2, 1, 8);
