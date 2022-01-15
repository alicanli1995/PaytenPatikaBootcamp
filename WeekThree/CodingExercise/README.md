# Coding Exercise

## • 2. Ödevde yer alan endpoint’lerin Spring Data ile veritabanı entegrasyonu yapılacaktır. Katmanlı mimari yaklaşımına uygun olarak (controller-service-dao) geliştirilmesi beklenmektedir.

> Bütün proje katmanlı mimari yaklaşımına göre tekrardan oluşturulmuş ve Postman üzerinden test edilmiştir. Uygulamada PostgresSQL ve Redis kullanılmıştır. Redis için : 6379 portu kullanılmıştır.

## • Postgresql veya MySql tercih edebilirsiniz.

> Ağırlıklı transactionlarda postgresSQL kullanılırken bazı caselerde native sql kullanılmıştır. 


##  • (Optional) En az bir noktaya Redis entegrasyonu ekleyerek datanın cache’ den getirilmesini sağlanacaktır.

> MemberController classında yer alan getAllMember endpointi için Redis Cache uygulanmıştır. Endpointe daha iyi gözlem yapılabilmesi açısından 2 saniye delay konulmuştur. İlk çağırmada cache yerine kendi metodunu kullandığı için 2.01 saniye gibi bir sürede return ederken 2. çağırmada Redis cache kullandığı için 6-8 ms aralığına düşmektedir. 3 çağırmada bir yenilenmesi açısından cache temizleme işlemi uygulanmıştır.

<a href="https://ibb.co/c2DhcXC"><img src="https://i.ibb.co/ssy9vJ6/Ads-z.png" alt="Ads-z" border="0" /></a>