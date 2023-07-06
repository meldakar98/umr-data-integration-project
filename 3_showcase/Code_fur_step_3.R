install.packages("dplyr")
library(dplyr)
install.packages("tidyr")
library(tidyr)

data = read.csv("EndSet_mcdonalds_semicolon_menue_3grouped.csv",header = TRUE, sep = ";",dec = ".")

data = data %>% 
  mutate(menue_bezeichnung = case_when(
    menue_bezeichnung == "niedriges_menue" ~ 1,
    menue_bezeichnung== "mittleres_menue"~ 2,
    menue_bezeichnung == "hohes_menue" ~ 3,
    ))


#Top 5 für Gewicht Männer
#die fünf  Länder mit dem geringsten Durchschnittsgewicht
data_sort = data[order(data$Gewicht_Mann),]
data_sort = data_sort[1:3720,]
mann_leicht_1 = subset(data_sort,Land == "Äthiopien")
mann_leicht_1 = mann_leicht_1[order(-mann_leicht_1$faktor_man),]
mann_leicht_1 = subset(mann_leicht_1,Activity == "Watering lawn or garden")

mann_leicht_2 = subset(data_sort,Land == "Bangladesch")
mann_leicht_2 = mann_leicht_2[order(-mann_leicht_2$faktor_man),]
mann_leicht_2 = subset(mann_leicht_2,Activity == "Watering lawn or garden")

mann_leicht_3 = subset(data_sort,Land == "Eritrea")
mann_leicht_3 = mann_leicht_3[order(-mann_leicht_3$faktor_man),]
mann_leicht_3 = subset(mann_leicht_3,Activity == "Watering lawn or garden")

mann_leicht_4 = subset(data_sort,Land == "Madagaskar")
mann_leicht_4 = mann_leicht_4[order(-mann_leicht_4$faktor_man),]
mann_leicht_4 = subset(mann_leicht_4,Activity == "Watering lawn or garden")

mann_leicht_5 = subset(data_sort,Land == "Osttimor")
mann_leicht_5 = mann_leicht_5[order(-mann_leicht_5$faktor_man),]
mann_leicht_5 = subset(mann_leicht_5,Activity == "Watering lawn or garden")

plot(mann_leicht_1$menue_bezeichnung,mann_leicht_1$faktor_man,col = "black",type = "l",xlim = c(1,3),main = "Wie lange müssen die 5 Länder mit dem geringsten männlichen Durchschnittsgewicht den Rasen bewässern?",axes = FALSE)
axis(1, at=seq(0,3, by=1))
axis(2, at=seq(0,20, by=1))
lines(mann_leicht_2$menue_bezeichnung,mann_leicht_2$faktor_man,col = "red")
lines(mann_leicht_3$menue_bezeichnung,mann_leicht_3$faktor_man,col= "blue")
lines(mann_leicht_4$menue_bezeichnung,mann_leicht_4$faktor_man,col= "green")
lines(mann_leicht_5$menue_bezeichnung,mann_leicht_5$faktor_man,col = "yellow")


#absteigende Sortierung: die Länder mit dem höchsten Durchschnittsgewicht

data_sort_desc <- data[order(-data$Gewicht_Mann),]
data_sort_desc = data_sort_desc[1:3720,]

mann_schwer_1 = subset(data_sort_desc,Land == "Amerikanisch Samoa")
mann_schwer_1 = mann_schwer_1[order(-mann_schwer_1$faktor_man),]
mann_schwer_1 = subset(mann_schwer_1,Activity == "Watering lawn or garden")

mann_schwer_2 = subset(data_sort_desc,Land == "Cookinseln")
mann_schwer_2 = mann_schwer_2[order(-mann_schwer_2$faktor_man),]
mann_schwer_2 = subset(mann_schwer_2,Activity == "Watering lawn or garden")

mann_schwer_3 = subset(data_sort_desc,Land == "Französisch-Polynesien")
mann_schwer_3 = mann_schwer_3[order(-mann_schwer_3$faktor_man),]
mann_schwer_3 = subset(mann_schwer_3,Activity == "Watering lawn or garden")

mann_schwer_4 = subset(data_sort_desc,Land == "Tokelau")
mann_schwer_4 = mann_schwer_4[order(-mann_schwer_4$faktor_man),]
mann_schwer_4 = subset(mann_schwer_4,Activity == "Watering lawn or garden")

mann_schwer_5 = subset(data_sort_desc,Land == "Niue")
mann_schwer_5 = mann_schwer_5[order(-mann_schwer_5$faktor_man),]
mann_schwer_5 = subset(mann_schwer_5,Activity == "Watering lawn or garden")

plot(mann_schwer_1$menue_bezeichnung,mann_schwer_1$faktor_man,col = "black",type = "l",xlim = c(1,3),main = "Wie lange müssen die 5 Länder mit dem höchsten männlichen Durchschnittsgewicht den Rasen bewässern?",axes = FALSE)
axis(1, at=seq(0,3, by=1))
axis(2, at=seq(0,20, by=1))
lines(mann_schwer_2$menue_bezeichnung,mann_schwer_2$faktor_man,col = "red")
lines(mann_schwer_3$menue_bezeichnung,mann_schwer_3$faktor_man,col= "blue")
lines(mann_schwer_4$menue_bezeichnung,mann_schwer_4$faktor_man,col= "green")
lines(mann_schwer_5$menue_bezeichnung,mann_schwer_5$faktor_man,col = "yellow")

#Frauen
#die zehn leichtesten Länder
data_sort_1 = data[order(data$Gewicht_Frau),]
data_sort_1 = data_sort_1[1:5418,]

frau_leicht_1 = subset(data_sort_1,Land == "Indien")
frau_leicht_1 = frau_leicht_1[order(-frau_leicht_1$faktor_woman),]
frau_leicht_1 = subset(frau_leicht_1,Activity == "Boating, power, speed boat")

frau_leicht_2 = subset(data_sort_1,Land == "Bangladesch")
frau_leicht_2 = frau_leicht_2[order(-frau_leicht_2$faktor_woman),]
frau_leicht_2 = subset(frau_leicht_2,Activity == "Watering lawn or garden")

frau_leicht_3 = subset(data_sort_1,Land == "Burundi")
frau_leicht_3 = frau_leicht_3[order(-frau_leicht_3$faktor_woman),]
frau_leicht_3 = subset(frau_leicht_3,Activity == "Watering lawn or garden")

frau_leicht_4 = subset(data_sort_1,Land == "Madagaskar")
frau_leicht_4 = frau_leicht_4[order(-frau_leicht_4$faktor_woman),]
frau_leicht_4 = subset(frau_leicht_4,Activity == "Watering lawn or garden")

frau_leicht_5 = subset(data_sort_1,Land == "Osttimor")
frau_leicht_5 = frau_leicht_5[order(-frau_leicht_5$faktor_woman),]
frau_leicht_5 = subset(frau_leicht_5,Activity == "Watering lawn or garden")

plot(frau_leicht_1$menue_bezeichnung,frau_leicht_1$faktor_woman,col = "black",type = "l",xlim = c(1,3),ylim = (1,20),main = "Wie lange müssen die 5 Länder mit dem geringsten männlichen Durchschnittsgewicht den Rasen bewässern?",axes = FALSE)
axis(1, at=seq(0,3, by=1))
axis(2, at=seq(0,20, by=1))
lines(frau_leicht_2$menue_bezeichnung,frau_leicht_2$faktor_woman,col = "red")
lines(frau_leicht_3$menue_bezeichnung,frau_leicht_3$faktor_woman,col= "blue")
lines(frau_leicht_4$menue_bezeichnung,frau_leicht_4$faktor_woman,col= "green")
lines(frau_leicht_5$menue_bezeichnung,frau_leicht_5$faktor_woman,col = "yellow")

#absteigende Sortierung: die schwersten Länder

data_sort_desc_1 <- data[order(-data$Gewicht_Frau),]
data_sort_desc_1 = data_sort_desc_1[1:4464,]

frau_schwer_1 = subset(data_sort_desc_1,Land == "Amerikanisch Samoa")
frau_schwer_1 = frau_schwer_1[order(-frau_schwer_1$faktor_woman),]
frau_schwer_1 = subset(frau_schwer_1,Activity == "Watering lawn or garden")

frau_schwer_2 = subset(data_sort_desc_1,Land == "Cookinseln")
frau_schwer_2 = frau_schwer_2[order(-frau_schwer_2$faktor_woman),]
frau_schwer_2 = subset(frau_schwer_2,Activity == "Watering lawn or garden")

frau_schwer_3 = subset(data_sort_desc_1,Land == "Niue")
frau_schwer_3 = frau_schwer_3[order(-frau_schwer_3$faktor_woman),]
frau_schwer_3 = subset(frau_schwer_3,Activity == "Watering lawn or garden")

frau_schwer_4 = subset(data_sort_desc_1,Land == "Tokelau")
frau_schwer_4 = frau_schwer_4[order(-frau_schwer_4$faktor_woman),]
frau_schwer_4 = subset(frau_schwer_4,Activity == "Watering lawn or garden")

frau_schwer_5 = subset(data_sort_desc_1,Land == "Tonga")
frau_schwer_5 = frau_schwer_5[order(-frau_schwer_5$faktor_woman),]
frau_schwer_5 = subset(frau_schwer_5,Activity == "Watering lawn or garden")

plot(frau_schwer_1$menue_bezeichnung,frau_schwer_1$faktor_woman,col = "black",type = "l",xlim = c(1,3),main = "Wie lange müssen die 5 Länder mit dem höchsten weiblichen Durchschnittsgewicht den Rasen bewässern?",axes = FALSE)
axis(1, at=seq(0,3, by=1))
axis(2, at=seq(0,20, by=1))
lines(frau_schwer_2$menue_bezeichnung,frau_schwer_2$faktor_woman,col = "red")
lines(frau_schwer_3$menue_bezeichnung,frau_schwer_3$faktor_woman,col= "blue")
lines(frau_schwer_4$menue_bezeichnung,frau_schwer_4$faktor_woman,col= "green")
lines(frau_schwer_5$menue_bezeichnung,frau_schwer_5$faktor_woman,col = "yellow")

#Kreisdiagramm für Deutschland mit den fünf Übungen, die bei einem Menü mit viel Kalorien am effektivsten sind

deutschland = subset(data,Land == "Deutschland")
deutschland = subset(deutschland,menue_bezeichnung==3)
deutschland_man = deutschland[order(deutschland$faktor_man),]
deutschland_woman = deutschland[order(deutschland$faktor_woman),]
deutschland_man = deutschland_man[1:5,]
deutschland_woman = deutschland_woman[1:5,]


beschriftung = c("Running, 10.9 mph (5.5 min mile)","Cross country skiing, uphill","Cycling, >20 mph, racing","Running, 10 mph (6 min mile)","Skin diving, fast")
pie(deutschland_man$faktor_man, labels = beschriftung, main = "die Top 5 Sportarten bei einem Menü mit vielen kcal für Männer", 
    col = c("blue", "yellow", "green", "orange", "red"))

beschriftung_w = c("Running, 10.9 mph (5.5 min mile)","Cross country skiing, uphill","Cycling, >20 mph, racing","Running, 10 mph (6 min mile)","Skin diving, fast")
pie(deutschland_woman$faktor_woman, labels = beschriftung_w, main = "die Top 5 Sportarten bei einem Menü mit vielen kcal für Frauen", 
    col = c("blue", "yellow", "green", "orange", "red"))

