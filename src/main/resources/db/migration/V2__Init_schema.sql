INSERT INTO history (id, matches, player_one_set_points, player_one_match_points, player_two_set_points, player_two_match_points)
VALUES (1, '[]', 0, 0, 0, 0)
ON CONFLICT (id) DO NOTHING;
