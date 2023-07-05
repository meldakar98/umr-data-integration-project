CREATE TABLE `persistent_result_set` (
                                         `Land` varchar(23) DEFAULT NULL,
                                         `Gewicht_Mann` double DEFAULT NULL,
                                         `Gewicht_Frau` double DEFAULT NULL,
                                         `Activity` varchar(45) DEFAULT NULL,
                                         `kcal_per_h_woman` decimal(10,2) DEFAULT NULL,
                                         `kcal_per_h_man` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


Insert into persistent_result_set 
SELECT
    `laneder_gewicht_kcal`.`Land` AS `Land`,
    `laneder_gewicht_kcal`.`Gewicht_Mann` AS `Gewicht_Mann`,
    `laneder_gewicht_kcal`.`Gewicht_Frau` AS `Gewicht_Frau`,
    `laneder_gewicht_kcal`.`Activity` AS `Activity`,
    `faktor_training`(
        `laneder_gewicht_kcal`.`next_weight_up_woman`,
        `laneder_gewicht_kcal`.`next_weight_down_woman`,
        `laneder_gewicht_kcal`.`kcal_woman_next_up`,
        `laneder_gewicht_kcal`.`kcal_woman_next_down`,
        `laneder_gewicht_kcal`.`Gewicht_Frau`
    ) AS `kcal_per_h_woman`,
    `faktor_training`(
        `laneder_gewicht_kcal`.`next_weight_up_man`,
        `laneder_gewicht_kcal`.`next_weight_down_man`,
        `laneder_gewicht_kcal`.`kcal_man_next_up`,
        `laneder_gewicht_kcal`.`kcal_man_next_down`,
        `laneder_gewicht_kcal`.`Gewicht_Mann`
    ) AS `kcal_per_h_man`
FROM
    (
        SELECT
            `laender_gewicht`.`Land` AS `Land`,
            `laender_gewicht`.`Gewicht_Mann` AS `Gewicht_Mann`,
            `laender_gewicht`.`Gewicht_Frau` AS `Gewicht_Frau`,
            `laender_gewicht`.`next_weight_up_woman` AS `next_weight_up_woman`,
            `laender_gewicht`.`next_weight_down_woman` AS `next_weight_down_woman`,
            `laender_gewicht`.`next_weight_up_man` AS `next_weight_up_man`,
            `laender_gewicht`.`next_weight_down_man` AS `next_weight_down_man`,
            `laender_gewicht`.`Activity` AS `Activity`,
            (
                SELECT `transposed_excercise`.`kcal`
                FROM `transposed_excercise`
                WHERE
                    `transposed_excercise`.`Activity` = `laender_gewicht`.`Activity`
                    AND `transposed_excercise`.`weight` = `laender_gewicht`.`next_weight_up_woman`
            ) AS `kcal_woman_next_up`,
            (
                SELECT `transposed_excercise`.`kcal`
                FROM `transposed_excercise`
                WHERE
                    `transposed_excercise`.`Activity` = `laender_gewicht`.`Activity`
                    AND `transposed_excercise`.`weight` = `laender_gewicht`.`next_weight_down_woman`
            ) AS `kcal_woman_next_down`,
            (
                SELECT `transposed_excercise`.`kcal`
                FROM `transposed_excercise`
                WHERE
                    `transposed_excercise`.`Activity` = `laender_gewicht`.`Activity`
                    AND `transposed_excercise`.`weight` = `laender_gewicht`.`next_weight_up_man`
            ) AS `kcal_man_next_up`,
            (
                SELECT `transposed_excercise`.`kcal`
                FROM `transposed_excercise`
                WHERE
                    `transposed_excercise`.`Activity` = `laender_gewicht`.`Activity`
                    AND `transposed_excercise`.`weight` = `laender_gewicht`.`next_weight_down_man`
            ) AS `kcal_man_next_down`
        FROM
            (
                SELECT
                    `laender_gewicht_cp`.`Land` AS `Land`,
                    `laender_gewicht_cp`.`Gewicht_Mann` AS `Gewicht_Mann`,
                    `laender_gewicht_cp`.`Gewicht_Frau` AS `Gewicht_Frau`,
                    `laender_gewicht_cp`.`next_weight_up_woman` AS `next_weight_up_woman`,
                    `laender_gewicht_cp`.`next_weight_down_woman` AS `next_weight_down_woman`,
                    `laender_gewicht_cp`.`next_weight_up_man` AS `next_weight_up_man`,
                    `laender_gewicht_cp`.`next_weight_down_man` AS `next_weight_down_man`,
                    `excercise`.`Activity` AS `Activity`
                FROM
                    (
                        (
                            SELECT
                                `laendermcdonalds`.`Land` AS `Land`,
                                `laendermcdonalds`.`Gewicht_Mann` AS `Gewicht_Mann`,
                                `laendermcdonalds`.`Gewicht_Frau` AS `Gewicht_Frau`,
                                `laendermcdonalds`.`next_weight_up_woman` AS `next_weight_up_woman`,
                                `laendermcdonalds`.`next_weight_down_woman` AS `next_weight_down_woman`,
                                `laendermcdonalds`.`next_weight_up_man` AS `next_weight_up_man`,
                                `laendermcdonalds`.`next_weight_down_man` AS `next_weight_down_man`
                            FROM
                                (
                                    SELECT
                                        `laenderquelle`.﻿Land AS `Land`,
                                        `laenderquelle`.`Gewicht_Mann` AS `Gewicht_Mann`,
                                        `laenderquelle`.`Gewicht_Frau` AS `Gewicht_Frau`,
                                        (
                                            SELECT
                                                (MIN(`weight_woman_up`.`weight_as_int`) / 2.2046)
                                            FROM
                                                `weight_to_value` `weight_woman_up`
                                            WHERE
                                                `weight_woman_up`.`weight_as_int` >= (`laenderquelle`.`Gewicht_Frau` * 2.2046)
                                        ) AS `next_weight_up_woman`,
                                        (
                                            SELECT
                                                (MAX(`weight_woman_down`.`weight_as_int`) / 2.2046)
                                            FROM
                                                `weight_to_value` `weight_woman_down`
                                            WHERE
                                                `weight_woman_down`.`weight_as_int` <= (`laenderquelle`.`Gewicht_Frau` * 2.2046)
                                        ) AS `next_weight_down_woman`,
                                        (
                                            SELECT
                                                (MIN(`weight_man_up`.`weight_as_int`) / 2.2046)
                                            FROM
                                                `weight_to_value` `weight_man_up`
                                            WHERE
                                                `weight_man_up`.`weight_as_int` >= (`laenderquelle`.`Gewicht_Mann` * 2.2046)
                                        ) AS `next_weight_up_man`,
                                        (
                                            SELECT
                                                (MAX(`weight_man_down`.`weight_as_int`) / 2.2046)
                                            FROM
                                                `weight_to_value` `weight_man_down`
                                            WHERE
                                                `weight_man_down`.`weight_as_int` <= (`laenderquelle`.`Gewicht_Mann` * 2.2046)
                                        ) AS `next_weight_down_man`
                                    FROM
                                        `laender` AS `laenderquelle`
                                ) `laendermcdonalds`
                        )
                        `laender_gewicht_cp`
                        JOIN
                        (
                            SELECT
                                DISTINCT `transposed_excercise`.`Activity` AS `Activity`
                            FROM
                                `transposed_excercise`
                        ) `excercise`
                    )
            ) `laender_gewicht`
    ) `laneder_gewicht_kcal`