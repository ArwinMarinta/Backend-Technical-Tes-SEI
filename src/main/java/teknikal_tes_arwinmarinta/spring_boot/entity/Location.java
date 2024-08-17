package teknikal_tes_arwinmarinta.spring_boot.entity;


import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="lokasi")


public class Location {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private int id;

    @Column(name = "nama_lokasi")
    private String locationName;

    @Column(name = "negara")
    private String country;

    @Column(name="provinsi")
    private String province;

    @Column(name="kota")
    private String city;

    @Column(name="created_at")
    private java.sql.Timestamp createAt;

    @ManyToMany(mappedBy = "locations")
    private Set<Proyek> projects;
}
