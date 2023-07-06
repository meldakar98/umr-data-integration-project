Create View menue_kombos as (
select * from (
Select  Bezeichnung as Haupspeise_Bezeichnung,
        Menge as Haupspeise_Menge,
        kcal as Haupspeise_kcal,
        Einheit as Haupspeise_Einheit FROM dataintegration.mcdonalds where Einheit = 1) as Haupspeise
    Cross Join
(Select Bezeichnung as Beilage_Bezeichnung,
        Menge as Beilage_Menge,
        kcal as Beilage_kcal,
        Einheit as Beilage_Einheit FROM dataintegration.mcdonalds where Einheit = 2) as Beilage
    Cross Join
(Select Bezeichnung as Getraenk_Bezeichnung,
        Menge as Getraenk_Menge,
        kcal as Getraenk_kcal,
        Einheit as Getraenk_Einheit FROM dataintegration.mcdonalds where Einheit = 3) as Getraenk
    Cross Join
(Select Bezeichnung as Sauce_Bezeichnung,
        Menge as Sauce_Menge,
        kcal as Sauce_kcal,
        Einheit as Sauce_Einheit FROM dataintegration.mcdonalds where Einheit = 4) as Sauce);