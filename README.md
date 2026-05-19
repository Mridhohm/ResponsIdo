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


Saya Membuat Class baru di dalam Package database yang bernama DatabaseKonek.java
di dalamnya ada

~~~public Connection getConnection() throws SQLException {
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
~~~
Dan Juga
~~~public static void initializeDatabase() {
        String baseUrl =
            "jdbc:mysql://" + DB_HOST + ":" + DB_PORT
            + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Jakarta";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection c = DriverManager.getConnection(baseUrl, DB_USER, DB_PASS);
                 Statement s = c.createStatement()) {
                s.executeUpdate(
                    "CREATE DATABASE IF NOT EXISTS `" + DB_NAME + "` "
                    + "CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci"
                );
            }
            try (Connection c = DriverManager.getConnection(URL, DB_USER, DB_PASS);
                 Statement s = c.createStatement()) {
                s.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `cart_items` ("
                    + "`id`         INT AUTO_INCREMENT PRIMARY KEY, "
                    + "`name`       VARCHAR(255) NOT NULL UNIQUE, "
                    + "`price`      DOUBLE NOT NULL, "
                    + "`quantity`   INT NOT NULL DEFAULT 1, "
                    + "`created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4"
                );
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver tidak ditemukan!", e);
        } catch (SQLException e) {
            throw new RuntimeException(
                """
                Gagal inisialisasi
                Pastikan MySQL berjalan dan konfigurasi sudah benar.
                Error: """ + e.getMessage(), e
            );
        }
    }
}
~~~

Untuk Menghubungkan dan Menginisialisasi Database Mysql

Skema Tabel Database

```sql
CREATE TABLE `cart_items` (
    `id`         INT AUTO_INCREMENT PRIMARY KEY,
    `name`       VARCHAR(255) NOT NULL UNIQUE,
    `price`      DOUBLE NOT NULL,
    `quantity`   INT NOT NULL DEFAULT 1,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```

---

Ada Pula Package Diskon yang ditambahkan dan berfungsi sebagai DiscountStrategy untuk mengimplemenmtasikan Diskon dan Event 12.12

~~~package eventdiskonan;

public class Event implements Diskon {

    private static final double DISCOUNT_RATE = 0.12;

    @Override
    public double calculateDiscount(double totalAmount) {
        return totalAmount * DISCOUNT_RATE;
    }

    @Override
    public String getDiscountName() {
        return "Event 12.12 (12%)";
    }
}
~~~
