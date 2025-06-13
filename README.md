# Veteriner Yönetim Sistemi

Bu proje, bir veteriner kliniğinin işlerini yönetebilmesi için geliştirilmiş bir API sunmaktadır. API, veteriner çalışanları tarafından kullanılacak şekilde tasarlanmıştır.

## Başlangıç

Projeyi yerel bilgisayarınıza klonlayın ve çalıştırmak için aşağıdaki adımları izleyin.

### Gereksinimler

- Java 8 veya üzeri
- Maven
- PostgreSQL veya MySQL veritabanı

### Kurulum

1. Projeyi klonlayın:

   ```bash
   git clone https://github.com/cisagl/veteriner-yonetim-sistemi.git
   cd Veterinary-Management-System
   ```

2. Veritabanını oluşturun (PostgreSQL veya MySQL kullanabilirsiniz).

3. `application.properties` dosyasını düzenleyin ve veritabanı bağlantı bilgilerinizi ekleyin.

4. Proje kök dizininde aşağıdaki komutu çalıştırarak uygulamayı başlatın:

   ```bash
   mvn spring-boot:run
   ```

Uygulama varsayılan olarak `http://localhost:8080` adresinde çalışacaktır.

## API Dokümantasyonu

Projenin API'larını kullanmak için aşağıdaki end pointleri gözden geçirebilirsiniz:

| Endpoint                                                                                                                                 | HTTP Metodu | Açıklama                                                                   |
|------------------------------------------------------------------------------------------------------------------------------------------|-------------|----------------------------------------------------------------------------|
| ANIMALS                                                                                                                                  |
| `/v1/animals/all`                                                                                                                        | GET         | Tüm hayvanları listele                                                     |
| `/v1/animals/{id}`                                                                                                                       | GET         | Belirtilen ID'ye sahip hayvanı getir                                       |
| `/v1/animals/name?name={name}`                                                                                                           | GET         | Belirtilen isme sahip hayvanı getir                                        |
| `/v1/animals/customer?id={id}`                                                                                                           | GET         | Belirtilen Customer ID'sinin hayvanlarını getir                            |
| `/v1/animals/save`                                                                                                                       | POST        | Yeni hayvan ekle                                                           |
| `/v1/animals/update/{id}`                                                                                                                | PUT         | Belirtilen ID'ye sahip hayvanı güncelle                                    |
| `/v1/animals/delete/{id}`                                                                                                                | DELETE      | Belirtilen ID'ye sahip hayvanı sil                                         |
| CUSTOMERS                                                                                                                                |
| `/v1/customers/all`                                                                                                                      | GET         | Tüm müşterileri listele                                                    |
| `/v1/customers/{id}`                                                                                                                     | GET         | Belirtilen ID'ye sahip müşteriyi getir                                     |
| `/v1/customers/name?name={name}`                                                                                                         | GET         | Belirtilen isme sahip müşteriyi getir                                      |
| `/v1/customers/save`                                                                                                                     | POST        | Yeni müşteri ekle                                                          |
| `/v1/customers/update/{id}`                                                                                                              | PUT         | Belirtilen ID'ye sahip müşteriyi güncelle                                  |
| `/v1/customers/delete/{id}`                                                                                                              | DELETE      | Belirtilen ID'ye sahip müşteriyi sil                                       |
| VACCINES                                                                                                                                 |
| `/v1/vaccines/all`                                                                                                                       | GET         | Tüm aşıları listele                                                        |
| `/v1/vaccines/{id}`                                                                                                                      | GET         | Belirtilen ID'ye sahip aşıyı getir                                         |
| `/v1/vaccines/animal?id={id}`                                                                                                            | GET         | Belirtilen Animal ID'ye sahip hayvanın aşılarını getir                     |
| `/v1/vaccines/animals?protectionStartDate={startDate}&protectionFinishDate={finishDate}`                                                 | GET         | Aşı koruyuculuk bitiş tarihi yaklaşan hayvanları getir                     |
| `/v1/vaccines/save`                                                                                                                      | POST        | Yeni aşı ekle                                                              |
| `/v1/vaccines/update/{id}`                                                                                                               | PUT         | Belirtilen ID'ye sahip aşıyı güncelle                                      |
| `/v1/vaccines/delete/{id}`                                                                                                               | DELETE      | Belirtilen ID'ye sahip aşıyı sil                                           |
| APPOINTMENTS                                                                                                                             |
| `/v1/appointments/all`                                                                                                                   | GET         | Tüm randevuları listele                                                    |
| `/v1/appointments/{id}`                                                                                                                  | GET         | Belirtilen ID'ye sahip randevuyu getir                                     |
| `/v1/appointments/date&doctor?startDate={startDate}&endDate={endDate} !!! RequestBody olarak JSON formatında Doctor ID girilmelidir !!!` | GET         | Belirtilen tarihler arasındaki ve Doktor ID'siyle uyuşan randevuları getir |
| `/v1/appointments/date&animal?startDate={startDate}&endDate={endDate} !!! RequestBody olarak JSON formatında Animal ID girilmelidir !!!` | GET         | Belirtilen tarihler arasındaki ve Animal ID'siyle uyuşan randevuları getir |
| `/v1/appointments/save`                                                                                                                  | POST        | Yeni randevu oluştur                                                       |
| `/v1/appointments/update/{id}`                                                                                                           | PUT         | Belirtilen ID'ye sahip randevuyu güncelle                                  |
| `/v1/appointments/delete/{id}`                                                                                                           | DELETE      | Belirtilen ID'ye sahip randevuyu sil                                       |
| DOCTORS                                                                                                                                  |
| `/v1/doctors/all`                                                                                                                        | GET         | Tüm doktorları listele                                                     |
| `/v1/doctors/{id}`                                                                                                                       | GET         | Belirtilen ID'ye sahip doktoru getir                                       |
| `/v1/doctors/save`                                                                                                                       | POST        | Yeni doktor ekle                                                           |
| `/v1/doctors/update/{id}`                                                                                                                | PUT         | Belirtilen ID'ye sahip doktoru güncelle                                    |
| `/v1/doctors/delete/{id}`                                                                                                                | DELETE      | Belirtilen ID'ye sahip doktoru sil                                         |
| AVAILABLE DATES                                                                                                                          |
| `v1/available-dates/all`                                                                                                                 | GET         | Tüm müsait günleri listele                                                 |
| `v1/available-dates/{id}`                                                                                                                | GET         | Belirtilen ID'ye sahip müsait günleri getir                                |
| `v1/available-dates/save`                                                                                                                | POST        | Yeni müsait gün oluştur                                                    |
| `v1/available-dates/update/{id}`                                                                                                         | PUT         | Belirtilen ID'ye sahip müsait günü güncelle                                |
| `v1/available-dates/delete/{id}`                                                                                                         | DELETE      | Belirtilen ID'ye sahip müsait günü sil                                     |

## UML Diyagramı

Projede kullanılan UML diyagramına [buradan](https://prnt.sc/nIVwk-SV1Al-) ulaşabilirsiniz.

## Teknolojiler

- Java Spring Boot
- Spring Data JPA
- PostgreSQL (Örnek veri tabanı `vet.sql` dosyasıyla GitHub'a yüklenmiştir)
- Maven

## İletişim
Eğer proje ile ilgili bir sorun iletmek ya da geri bildirim vermek isterseniz aşağıdaki adresten proje sahibine ulaşabilirsiniz:

[Github](https://github.com/cisagl)
