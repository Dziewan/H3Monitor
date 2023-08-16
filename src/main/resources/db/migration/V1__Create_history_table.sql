CREATE TABLE history
(
    id                      BIGINT PRIMARY KEY,
    matches                 TEXT              NOT NULL,
    player_one_set_points   INTEGER DEFAULT 0 NOT NULL,
    player_one_match_points INTEGER DEFAULT 0 NOT NULL,
    player_two_set_points   INTEGER DEFAULT 0 NOT NULL,
    player_two_match_points INTEGER DEFAULT 0 NOT NULL
);
