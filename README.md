# ResponsIdo

Ido keren

Jadi di Responsi ini saya menambahkan beberapa hal kedalam project responsi yang sudah di berikan, diantaranya adalah:

1. Ubah supaya data disimpan di database (MySQL).
2. Terapkan Fitur Diskon Event 12.12.
3. Gunakan pola arsitektur (contoh: MVC, MVP, MVVM, dsb)
4. Hanya boleh menambah (file/package), tidak boleh mengubah file sama sekali
(kecuali file Main.java/entry point).\
5. Fitur dan UI aplikasi harus sama persis dengan sebelum dikerjakan.
6. Berikan README.md yang berisi penjelasan apa yang anda lakukan
7. Kumpulkan dalam bentuk link GitHub.

   
>>> Saya Membuat Class baru di dalam Package database yang bernama DatabaseKonek.java
di dalamnya ada
>>> public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, DB_USER, DB_PASS);
            } catch (ClassNotFoundException e) {
                throw new SQLException("Driver tidak ditemukan.", e);
            }
        }
        return connection;
    }
