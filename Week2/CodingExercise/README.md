# • Film ve Kullanıcı CRUD endpoint’ lerinin REST pratiklerine uygun olarak yazılması (Aşağıdaki 6 maddeye karşılık gelen birer metot yazılacak. Metotlarınızı postman üzerinden test etmeniz tavsiye olunur.)

• **MovieController (Fields -> name, genre (enum), releaseYear, director, cast (Liste, oyuncular)**
1. Create -> HTTP 201 Dönecek

<a href="https://ibb.co/zsD3rTv"><img src="https://i.ibb.co/0qv0cRb/1.png" alt="1" border="0" /></a>

2. GET isteği için HTTP 200 dönecek

<a href="https://ibb.co/hY3yyGF"><img src="https://i.ibb.co/dm8rrN4/Ads-z.png" alt="Ads-z" border="0" /></a>


3. DELETE için HTTP 204 dönecek (Girilen ID'ye göre silme işlemi yapmaktadır. Tekrar get yaptığımızda silindiği görülüyor.)

<a href="https://ibb.co/TPQywDg"><img src="https://i.ibb.co/mhnpRrc/Ads-z.png" alt="Ads-z" border="0" /></a>


• **MemberController (gerekli field’lar tarafınızdan belirlenecek.)**

4. Kullanıcı filmlere puan verebilecek - member id, movie id, point (Mevcut movie listesine memberId, movieId ve point olacak şekilde property geçerek puanlama işlemi yapılmaktadır.)

<a href="https://ibb.co/zVLvLdY"><img src="https://i.ibb.co/b5y9ytZ/Ads-z.png" alt="Ads-z" border="0" /></a>


5. Kullanıcılara kendilerine izleme listesi oluşturabilecek (watchlist) - member id, watch list name (memberId ve watcListName geçilerek oluşturulabilmektedir.)

<a href="https://ibb.co/FVRsNwJ"><img src="https://i.ibb.co/JQDx072/Ads-z.png" alt="Ads-z" border="0" /></a>

6. Kullanıcılar izleme listelerine film ekleyebilecek - watch list id, movie id (Örnek olarak yukarı da oluşturduğumuz watchList'e movieId'si 2 olan film eklenmektedir.)

<a href="https://ibb.co/2YMj85b"><img src="https://i.ibb.co/HpPrNXJ/Ads-z.png" alt="Ads-z" border="0" /></a>


• Controller sınıfındaki metotlar builder ile oluşturulmuş dummy veri dönecek.

• (Bonus) Projeye Swagger entegre edilmesi

## **Swagger entegre edilmiştir bütün methodlar ve açıklamaları yapılmıştır swagger apisi aşağıda ki gibi çalışmaktadır. Kodlar execute özelliği ile ve postman ile test edilmiş ve çalışmıştır**

<a href="https://img.onl/4cVpB6"><img src="https://img.onl/4cVpB6" alt="1" border="0" /></a>

<a href="https://img.onl/KzuIXg"><img src="https://img.onl/KzuIXg" alt="3" border="0" /></a>

<a href="https://img.onl/GQEFpN"><img src="https://img.onl/GQEFpN" alt="2" border="0" /></a>