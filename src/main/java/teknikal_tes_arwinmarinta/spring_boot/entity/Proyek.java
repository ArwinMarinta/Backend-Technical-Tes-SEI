package teknikal_tes_arwinmarinta.spring_boot.entity;


import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="lokasi")

public class Proyek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int Id;

    @Column(name= "nama_proyek")
    private String nameProject;

    private String client;

    @Column(name="tgl_mulai")
    private java.util.Date startDate;

    @Column(name="tgl_selesai")
    private java.util.Date endDate;

    @Column(name="pimpinan_proyek")
    private String projectLeader;

    @Column(name="keterangan")
    private String description;

    @Column(name="create_at")
    private java.sql.Timestamp createAt;

    @ManyToMany
    @JoinTable(
        name = "proyek_lokasi",
        joinColumns = @JoinColumn(name = "proyek_id"),
        inverseJoinColumns = @JoinColumn(name = "lokasi_id")
    )
    private Set<Location> locations;

}
