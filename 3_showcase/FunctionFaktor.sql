DELIMITER //

Create function faktor_training(weight_up decimal(10,2), weight_down decimal(10,2), kcal_up decimal(10,2), kcal_down decimal(10,2), 
kg_person Decimal(10,2))
returns decimal(10,2)
deterministic

Begin
	declare kcal_per_h Decimal(10,2);
    
    IF (weight_up is not null And weight_down is not null) Then
    
		Set kcal_per_h = kcal_down + ((kcal_up - kcal_down)*((kg_person - weight_down)/(weight_up - weight_down)));
    
    End if;
    
    IF weight_up  is null Then 
		
        Set kcal_per_h = kcal_down * (kg_person/weight_down);
        
    End If;
    
    If weight_down is null Then 
    
		Set kcal_per_h = kcal_up * (kg_person/weight_up);
    
    End if;
    
    Return kcal_per_h;


End //
DELIMITER;
