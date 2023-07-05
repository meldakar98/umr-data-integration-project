CREATE TABLE `persistent_menue_kombos_mit_rowid` (
                                                     `Haupspeise_Bezeichnung` varchar(46) DEFAULT NULL,
                                                     `Haupspeise_Menge` varchar(11) DEFAULT NULL,
                                                     `Haupspeise_kcal` int DEFAULT NULL,
                                                     `Haupspeise_Einheit` int DEFAULT NULL,
                                                     `Beilage_Bezeichnung` varchar(46) DEFAULT NULL,
                                                     `Beilage_Menge` varchar(11) DEFAULT NULL,
                                                     `Beilage_kcal` int DEFAULT NULL,
                                                     `Beilage_Einheit` int DEFAULT NULL,
                                                     `Getraenk_Bezeichnung` varchar(46) DEFAULT NULL,
                                                     `Getraenk_Menge` varchar(11) DEFAULT NULL,
                                                     `Getraenk_kcal` int DEFAULT NULL,
                                                     `Getraenk_Einheit` int DEFAULT NULL,
                                                     `Sauce_Bezeichnung` varchar(46) DEFAULT NULL,
                                                     `Sauce_Menge` varchar(11) DEFAULT NULL,
                                                     `Sauce_kcal` int DEFAULT NULL,
                                                     `Sauce_Einheit` int DEFAULT NULL,
                                                     `total_kcal` int DEFAULT NULL,
                                                     `rowid` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


Insert into persistent_menue_kombos_mit_rowid select Haupspeise_Bezeichnung, Haupspeise_Menge, Haupspeise_kcal, Haupspeise_Einheit, Beilage_Bezeichnung, Beilage_Menge, Beilage_kcal, Beilage_Einheit, Getraenk_Bezeichnung, Getraenk_Menge, Getraenk_kcal, Getraenk_Einheit, Sauce_Bezeichnung, Sauce_Menge, Sauce_kcal, Sauce_Einheit, total_kcal
                                                   ,@rowid:=@rowid+1 as rowid from
    (Select  Haupspeise_Bezeichnung, Haupspeise_Menge, Haupspeise_kcal, Haupspeise_Einheit, Beilage_Bezeichnung, Beilage_Menge, Beilage_kcal, Beilage_Einheit, Getraenk_Bezeichnung, Getraenk_Menge, Getraenk_kcal, Getraenk_Einheit, Sauce_Bezeichnung, Sauce_Menge, Sauce_kcal, Sauce_Einheit
        ,(Haupspeise_kcal + Beilage_kcal + Getraenk_kcal + Sauce_kcal) as total_kcal
    from
    (select *
    from (
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
    Einheit as Sauce_Einheit FROM dataintegration.mcdonalds where Einheit = 4) as Sauce) as menue_view_kombos order by total_kcal) as result, (SELECT @rowid:=0) as init
ORDER BY rowid;