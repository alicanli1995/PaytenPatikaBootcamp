
# • https://martinfowler.com/articles/practical-test-pyramid.html adresindeki yazıyı okuyup özetini çıkarınız.

> The Test Pyramid

Yazar burada, yazılımımız için otomatik testler konusunda ciddi olmak istiyorsak, bilmemiz gereken önemli bir kavram olan test piramidinden bahsetmiştir. Bu piramdin çıkış noktasının Mike Cohn, "Succeeding with Agile" kitabı olduğu anlatılmaktadır.Bu kitap farklı test katmanları hakkında düşünmenizi söyleyen harika bir görsel metafor. Ayrıca, her katmanda ne kadar test yapılacağını da söyler.

![Regression Image](https://martinfowler.com/articles/practical-test-pyramid/testPyramid.png)

Fakat bu yaklaşımında aslında tam olarak yetmeyeceğinden bahsedilmektedir. Modern bir bakış açısından, test piramidi aşırı derecede basit görünüyor ve bu nedenle yanıltıcı olabilir.

> The Sample Application

* Functionality

Uygulamanın işlevselliği basittir. Üç endpoint ile bir REST arayüzü sağlar,


GET /hello	Her zaman "Hello World" döndürür.
GET /hello/{lastname}	Kişiye özel soyadına göre bir mesaj döndürür "Hello {Firstname} {Lastname}".
GET /weather	burada ise bölgeye göre bir hava durumu döndürüldüğünü gösterir. Hamburg, Germany.

> Unit tests

Test paketimizin temeli birim testlerden oluşacaktır. Birim testlerimiz kod tabanınızın belirli bir biriminin (test edilen konunuz) amaçlandığı şekilde çalıştığından emin olmaya yarar. Birim testleri, test paketimizdeki tüm testlerin en dar kapsamına sahiptir. Test paketinizdeki birim testlerinin sayısı, diğer test türlerinden büyük ölçüde daha fazla olacaktır.

> Integration Tests

Önemsiz olmayan tüm uygulamalar diğer bazı bölümlerle (veritabanları, dosya sistemleri, diğer uygulamalara yapılan ağ çağrıları) bütünleşir. Birim testleri yazarken, bunlar genellikle daha iyi izolasyon ve daha hızlı testler yapmak için dışarıda bıraktığınız parçalardır. Yine de uygulamanız diğer bölümlerle etkileşime girecek ve bunun test edilmesi gerekiyor. Entegrasyon Testleri yardımcı olmak için var. Uygulamanızın entegrasyonunu, uygulamanızın dışında yaşayan tüm parçalarla sınarlar.




# • Regression test nedir ? Kısaca açıklayınız.

*Yazılımda herhangi ufak bir değişiklik ya da yeni bir fonksiyon birçok beklenmedik sonuç doğurabilir. Regresyon testinin amacı, bu değişiklikler sonrası yazılımın hala doğru şekilde çalıştığını kontrol etmektir.*

*Regresyon testi liveda çalışan kodun üzerinde yapılan değişikliklerin kontrolü için kullanılır. Bu değişiklikler yeni bir fonksiyon, hata çözümü ya da performans geliştirmesi olabilir. Regresyon testleri genellikle değişiklikler son aşamaya geldiğinde ve yazılımın yeni sürümü yayınlamadan önce gerçekleştirilir. Regresyon testlerinin öncelikli amacı, uygulamanın kritik alanlarının hala beklendiği gibi çalıştığını kontrol etmektedir.* 

![Regression Image](https://miro.medium.com/max/724/0*egSCtZuMPj0Q9N0f)


# • A/B test nedir ? Kısaca açıklayınız.

*A / B testi (bölme testi veya kova testi olarak da bilinir) hangisinin daha iyi performans gösterdiğini belirlemek için bir web sayfasının veya uygulamanın iki sürümünü birbiriyle karşılaştırmanın bir yöntemidir. AB testi, esas olarak, bir sayfanın iki veya daha fazla varyantının rasgele kullanıcılara gösterildiği bir deneydir ve hangi varyasyonun belirli bir dönüşüm hedefi için daha iyi performans gösterdiğini belirlemek için istatistiksel analiz kullanılır.*

# • Black box / white box test kavramlarını açıklayınız.

***White box** testi aynı zamanda Glass box ve structure testing diye geçmekte. Bu test içeriğini yani kod kısmını görebildiğimiz, dolayısı ile hangi yolları takip edebildiğini, hangi parametreleri aldığını, içinde hangi döngülerin ve işlemlerin yapıldığını açıkça görebildiğimiz test türüdür. Böylece hangi sonuçları hangi basamaklar sonucunda alabileceğinin analizini yapabiliriz.*

***Black box** test de ise, white box test in aksine içerisinde hangi tür kod olduğunu bilmeyiz. Sadece input paramatrelerini verir ve output alırız.  Black box test daha çok uzman test grupları tarafında yazılır ve doğruluğu kabul edilmiş farz edileceği içi içeriği sorgulanmaz. Ben şu şu inputları verdim, sonuç ne olur, arkada neler yapıyor gerisi beni ilgilendirmez yaklaşımı ele alınmanktadır.*


# • Mutation test nedir ? Kısaca açıklayınız.

*Mutasyon Testi, kaynak koddaki belirli ifadeleri değiştirdiğimiz(mutant) ve test senaryolarının hataları bulabildiğini kontrol ettiğimiz bir tür yazılım testidir. Temelde birim testi(unit test) için kullanılan bir beyaz kutu testi türüdür. Mutant programdaki değişiklikler son derece küçük tutulur, bu nedenle programın genel hedefini etkilemez.*


*Mutasyon testinin amacı, mutant kodunu kaldıracak kadar sağlam olması gereken test vakalarının kalitesini değerlendirmektir. Bu yöntem, programda bir hata oluşturmayı içerdiği için hata tabanlı test stratejisi olarak da adlandırılır.*



# • Behavior Driven Development (BDD) nedir, neyi amaçlamaktadır ?

*Behavior Driven development (BDD), yazılım süreçlerinin daha test odaklı gitmesini sağlayan bir yaklaşımdır. Aynı zamanda müşteri ile aramızda yaşayan bir döküman oluşmasını sağlayabilir. BDD, Test Driven Development (TDD) gibi prensip olarak öncelikle test kodları yazılsın daha sonrasında proje kodu yazılsın anlayışını benimsemektedir.*


# • Agile test quadrant nedir ? Quadrant’ların kapsamını kısaca açıklayınız.

*Test Türlerinin iki yönünü birleştiren aşağıdaki Agile test quadrantları Brian Marick tarafından türetilmiştir.*

![Quadrant Test Image](https://www.tutorialspoint.com/agile_testing/images/quadrants.jpg)

*Agile test quadrant, ekiplerin gerekli testleri tanımlamasına, planlamasına ve yürütmesine yardımcı olacak yararlı bir sınıflandırma sağlar.*

* **Quadrant Q1,** Unit Level, Technology Facing ve developerları destekler.Birim testleri bu quadranta aittir. Bu testler otomatik testler olabilir.

* **Quadrant Q2,** System level, business facing ve ürün davranışına uygun olmasını kapsar. Fonksiyonel testler bu quadranta girer. Bu testler manuel ve otomatik test olarak yapılabilir.

* **Quadrant Q3,** Sistem veya User Acceptance Level, Business Facing ve gerçek zamanlı senaryolara odaklanma bu quadrant kapsamına girer. Bu testler manuel testlerdir.

* **Quadrant Q4,** Sistem ve Operational Acceptance Level, Technology Facing ve  Focus on Performance, Load, Stress, Maintainability, Scalability Tests gibi testler bu quadrant kapsamına girmektedir. Bu testler için otomasyon testleri ile birlikte özel toollar kullanılabilir.

*Bunları birleştirecek olursak, neyin ne zaman test edileceğini yansıtan Agile test quadrantları aşağıdaki gibi görselleştirilebilir.*

![Quadrant Test Image](https://www.tutorialspoint.com/agile_testing/images/testing_quadrants.jpg)


