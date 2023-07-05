DELIMITER //

CREATE FUNCTION closer_number(x DECIMAL(10,2), y DECIMAL(10,2), target DECIMAL(10,2))
    RETURNS DECIMAL(10,2)
    DETERMINISTIC
BEGIN
    DECLARE diff_x DECIMAL(10,2);
    DECLARE diff_y DECIMAL(10,2);

    SET diff_x = ABS(target - x);
    SET diff_y = ABS(target - y);

    IF diff_x < diff_y THEN
        RETURN x;
ELSE
        RETURN y;
END IF;
END //

DELIMITER ;
