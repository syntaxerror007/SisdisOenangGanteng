package com.sisdis.tugas2.Representation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by MartinOenang on 10/1/2015.
 */
public class ImageFile {
    String isi_berkas;
    String lokasi_berkas;
    String ukuran_berkas;

    public ImageFile() {

    }

    public ImageFile(String isi_berkas, String lokasi_berkas, String ukuran_berkas) {
        this.isi_berkas = isi_berkas;
        this.lokasi_berkas = lokasi_berkas;
        this.ukuran_berkas = ukuran_berkas;
    }

    @JsonProperty
    public String getIsi_berkas() {
        return isi_berkas;
    }

    @JsonProperty
    public String getLokasi_berkas() {
        return lokasi_berkas;
    }


    @JsonProperty
    public String getUkuran_berkas() {
        return ukuran_berkas;
    }
}
