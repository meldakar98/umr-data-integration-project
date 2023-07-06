Create View transposed_excercise AS
Select `﻿Activity, Exercise or Sport (1 hour)` as 'Activity', 130/2.2046 as weight, `130 lb` as kcal from excercise
Union all
Select `﻿Activity, Exercise or Sport (1 hour)`,155/2.2046 as weight, `155 lb` from excercise
Union all
Select `﻿Activity, Exercise or Sport (1 hour)`,180/2.2046 as weight, `180 lb` from excercise
Union all
Select `﻿Activity, Exercise or Sport (1 hour)`,205/2.2046 as weight, `205 lb` from excercise;


commit;