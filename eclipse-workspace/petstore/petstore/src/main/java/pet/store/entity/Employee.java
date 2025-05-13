package pet.store.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
   private Long employeeID; 
    
   private String employeeFirstName;
   private String employeeLastName;
   private String employeePhone;
   private String employeeJobTitle;

   @EqualsAndHashCode.Exclude
   @ToString.Exclude
   @ManyToOne (cascade = CascadeType.ALL)
   @JoinColumn (name = "pet_store_id")
   
   private PetStore petStore;
}

