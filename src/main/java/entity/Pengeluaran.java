package entity;

import lombok.*;

import java.sql.Date;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Pengeluaran {

    private Integer id;

    @NonNull
    private Double jumlah;

    @NonNull
    private String keterangan;

    @NonNull
    private Date tanggal;


}
