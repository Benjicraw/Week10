package pet.store.entity;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Data;
import lombok.ToString;
@Entity
@Data
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petStoreId;
    private String petStoreName;
    private String petStoreAddress;
    private String petStoreCity;
    private String petStoreState;
    private String petStoreZip;
    private String petStorePhone;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "pet_store_customer",
            joinColumns = @JoinColumn(name = "pet_store_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")) //needed research
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Customer> customers = new HashSet<>();
    @OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL, orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Employee> employees = new HashSet<>();
}