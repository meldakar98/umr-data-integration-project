Select Land,Gewicht_Mann,Gewicht_Frau,kcal_per_h_woman,kcal_per_h_man,kcal,menue_bezeichnung,Activity,
(kcal / kcal_per_h_man) as faktor_man,
(kcal / kcal_per_h_woman) as faktor_woman
 from persistent_result_set cross Join (Select avg(total_kcal) as kcal, IF(rowid<=99792,'niedriges_menue',IF(rowid<=199584,'mittleres_menue','hohes_menue')) as menue_bezeichnung from persistent_menue_kombos_mit_rowid group by menue_bezeichnung) as mc 