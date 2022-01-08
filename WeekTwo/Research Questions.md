# 1.Spring dışında dependency injection için kullanabileceğimiz framework’ler / kütüphaneler nelerdir ? (Herhangi bir programlama dili için olabilir.)

*Spring dışında kullanılan farklı dillerde ki dependency injection frameworkleri;*
* Weld,             -> Java
* Guice,            -> Java 
* Play framework,   -> Scala
* Salta,            -> Java
* Glassfish HK2,    -> Java
* Dagger,           -> Java
* Managed Extensibility Framework -> .NET Diller için

<img src="https://miro.medium.com/max/1200/1*8kLZmY3m5DXQJRjMZBI1ng.jpeg" alt="drawing" width="400"/>

# 2. @SpringBootApplication anotasyonu hangi anotasyonları kapsamaktadır ? Görevlerini kısaca açıklayınız.

```
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
```
*Anotasyonlarını kapsamaktadır.*
* Target : Annotation yapısının kullanım yerini kısıtlamak için @Target annotation kullanılır. Kısıtladığı alanlara da "ElementType" enumu içerisinden ulabiliriz burada koyabileceğimiz kısıtlardan bazıları; TYPE,FIELD, METHOD, CONSTRUCTOR gibi yapılar yer almaktadır.

* @Retention : Annotation yapısının Java Reflection ile kullanılabilmesi için @Retention ile belirtilmesi gerekir. @Retention parametre olarak RetentionPolicy numaralandırıcısını(SOURCE, CLASS, RUNTIME) alır. Değer RetentionPolicy.RUNTIME olduğunda annotation ile eklenen bilgiye Reflection yapısı ile erişilir. 

* @Documented : MongoDB'de kalıcı olan bir etki alanı nesnesini tanımlamak için kullanılır. Böylece bir Java sınıfını MongoDB içindeki bir koleksiyona eşlemek için kullanabiliriz.

* @Inherited : Parent sınıftaki anotasyonun alt sınıfa da geçmesini sağlar.

* @SpringBootConfiguration : Bu anotasyon @Target({ElementType.TYPE}), @Retention(RetentionPolicy.RUNTIME), @Documented, @Configuration, @Indexed ifadelerinin birleşimidir. @SpringBootConfiguration ifadesi @Configuration ifadesini kullanarak sınıfın bir bean sınıfı olduğunu belirtir.

* @EnableAutoConfiguration : Spring Boot projesinin temelini oluşturan varsayılan-otomatik ayarların yapılmasını sağlar.

* @ComponentScan : @ComponentScan aldığı parametreler aracılığıyla tarama yoluyla otomatik yapılandırmayı tetiklediğini belirtir.

# 3.@Primary, @Qualifer anotasyonlarının kullanım amaçlarını açıklayınız.

* @Primary : Basitçe söylemek gerekirse, aynı türden birden fazla @Bean olduğunda bir @Bean default olarak belirlemek için @Primary kullanırız.

* @Qualifer : Eğer biz beanimize birden fazla değer atama yaparsak yani spring konfigürasyon dosyasında birden fazla bean alanlarına tanımlama yaparsak Spring bu tanımlamalarının hangisinin kullanılacağına ” @Qualifier ” anotasyonunu kullanarak belirleriz.

# 4. Convention over configuration kavramını seçtiğiniz bir örnek üzerinden açıklayınız.

*Convention over configuration (aynı zamanda konvansiyonel kodlama olarak da bilinir), yazılım çerçeveleri tarafından kullanılan ve çerçeveyi kullanan bir geliştiricinin esnekliği kaybetmeden vermesi gereken kararların sayısını azaltmaya çalışan bir yazılım tasarım paradigmasıdır ve Kendinizi tekrar etmeyin (DRY) prensibini ilke alır.*

*Bir örnek verecek olursak, JavaBeans spesifikasyonu büyük ölçüde buna dayanır.*

* JavaBeans specification 1.01:

> "Genel bir kural olarak, insanların devralması gereken devasa bir java.beans.everything sınıfını her seferinde tekrar yazmak. Bunun yerine, JavaBeans çalışma zamanlarının 'normal' nesneleri için varsayılan davranış sağlamasını, ancak nesnelerin belirli bir java.beans.something arabiriminden devralarak belirli bir varsayılan davranışı geçersiz kılmasına izin vermesini istiyoruz."



<img src="https://devopedia.org/images/article/283/3882.1594900138.jpg" alt="drawing" width="600" height="400"/><img src="https://devopedia.org/images/article/283/6860.1594900096.jpg" alt="drawing" width="400" height="400"/>


# 5. Aspect Oriented Programlama nedir ? Avantajları ve dezavantajları nelerdir ?

*AOP, yazılımın karmaşıklığını azaltmaya, modülariteyi artırmaya yarayan bir yaklaşım biçimidir. Buradaki modülariteden kasıt uygulama süresince sistemin birçok bölümünde kullanılan, fonksiyonel olmayan kodun yani kesişen ilgilerin ufak ufak parçalara ayrılmasıdır.([Separation of Cross Cutting Concerns](https://en.wikipedia.org/wiki/Cross-cutting_concern)) Bu sayede uygulama genelinde kullanılacak olan yapıları, sistemden soyutlamış olup enkapsüle de ederek birçok yerde kullanılmasını sağlar. Genel olarak AOP bir sorunu çözmektense var olan sistemin daha güzel bir hale getirilmesini de sağlamaya yardımcı olur denilebilir.*

> Kendini tekrar etme. DRY (Don’t Repeat Yourself)

* Aspect Oriented Programming’in Avantajları;
    * 1. Tekrar eden kod bloklarından bizi kurtarıyor ve daha temiz ve anlaşılır bir yapı sunuyor.
    * 2. Uygulamaların bakım ve geliştirme maliyetlerini azaltmış oluyor.
    * 3. Modüler bir yapı elde etmemizi sağlıyor.
* Aspect Oriented Programming’in Dezavantajı;
    * 1. Süreç akışı dışında kalan aspect'ler bakım aşamasında karmaşaya sebep olabiliyor. (obliviousness(dikkatsizlik))


# 6. SOLID prensiplerini kısaca açıklayınız. Sizce her koşulda bu prensipler çerçevesinde mi kod yazılmalıdır ? Neden ?

* S — Single-responsibility principle
    * ÖZET: Bir sınıf (nesne) yalnızca bir amaç uğruna değiştirilebilir, o da o sınıfa yüklenen sorumluluktur, yani bir sınıfın(fonksiyona da indirgenebilir) yapması gereken yalnızca bir işi olması gerekir.
* O — Open-closed principle
    * ÖZET: Bir sınıf ya da fonksiyon halihazırda var olan özellikleri korumalı ve değişikliğe izin vermemelidir. Yani davranışını değiştirmiyor olmalı ve yeni özellikler kazanabiliyor olmalıdır.
* L — Liskov substitution principle
    * ÖZET: Kodlarımızda herhangi bir değişiklik yapmaya gerek duymadan alt sınıfları, türedikleri(üst) sınıfların yerine kullanabilmeliyiz.
* I — Interface segregation principle
    * ÖZET: Sorumlulukların hepsini tek bir arayüze toplamak yerine daha özelleştirilmiş birden fazla arayüz oluşturmalıyız.
* D — Dependency Inversion Principle
    * ÖZET: Sınıflar arası bağımlılıklar olabildiğince az olmalıdır özellikle üst seviye sınıflar alt seviye sınıflara bağımlı olmamalıdır.

*Mümkün olabildiğince SOLID prensiplerine bağlı kalınmalıdır. Çünkü genel yazılım geliştirme süreçleri daha tutarlı ve daha anlaşılır kod düzeyine bu şekilde ulaşılabilir. Yapılamayacağı caseler nadirende olsa olabilir. Bu gibi durumlarda bu prensibe yakın bir davranış uygulanması daha doğru olabilir.*

<img src="https://dijitalseruven.com/wp-content/uploads/2021/02/SOLID-1024x341.jpg" alt="drawing" width="600" height="200"/>


# 7. Swagger nedir, ne amaçla kullanılmaktadır ?

*Web API geliştirmede en önemli ihtiyaçlardan biri dokümantasyon ihtiyacıdır. Çünkü API methodlarının ne işe yaradığı ve nasıl kullanıldığı dokümantasyon içeresinde anlaşılır olması gerekir. Api dokümantasyonunu el emeği ile yazmak hem zordur hemde güncel tutması imkansızdır. Bir biçimde bu dokümantasyonu güncel olarak üretmek gerekir. Burada imdadımıza swagger yetişiyor.*

*Swagger’ın önemli bir amacı RestApi'ler için bir arayüz sağlamaktır. Bu hem insanların hemde bilgisayarlara kaynak koda erişmeden RestApi lerin özelliklerini görmesine, incelemesine ve anlamasına olanak sağlar.*

<img src="https://www.ugurbenli.com/img/2020-06-01-dotnet-core-projesine-swashbuckle-swagger-ekleme/swagger-logo.png" alt="drawing" width="500" height="100"/>



# 8. Richardson Maturity Model’i seviyeleriyle birlikte açıklayınız.



*Richardson Maturity Model Rest API’lerimizin hangi seviyede olgun olduğunu gösteren bir olgunluk seviyesidir. RMM 4 seviyeden oluşmaktadır ve 0’dan 3’e başlayan seviyeler, yukarı doğru çıktıkca daha etkin kullanıldığını ifade etmektedir.*

<img src="https://martinfowler.com/articles/images/richardsonMaturityModel/overview.png" alt="drawing" width="500" height="350"/>

* Level 0: Swamp of POX
    * Servisimizdeki sadece tek metod üzerinden POST olarak erişebildiğimiz seviyedir. Bu seviye transfer protokolü olarak da adlandırılmaktadır.
    <img src="https://martinfowler.com/articles/images/richardsonMaturityModel/level0.png" alt="drawing" width="400" height="150"/>

* Level 1: Resources
     * Servimizdeki URI üzerinden bir metot üzerinden erişilebildiğimiz seviyedir. Örnek URI http://localhost/students/1
     <img src="https://martinfowler.com/articles/images/richardsonMaturityModel/level1.png" alt="drawing" width="400" height="150"/>

* Level 2: HTTP verbs
    * POST, PUT, GET ve DELETE metotları çağırdığımız seviyedir.
    <img src="https://martinfowler.com/articles/images/richardsonMaturityModel/level2.png" alt="drawing" width="400" height="150"/>

* Level 3: Hypermedia controls
    * Servislerimizde URI’nin istek gönderip cevaba göre tekrar URI’ye istek yapabildiğimiz bir seviyedir. Servis üzerinden gelen cevaba göre akıştaki davranışı görebiliriz. HATEOAS kullandığımız seviyedir.
    <img src="https://i.ibb.co/g47dsQq/level3.png" alt="drawing" width="400" height="150"/>



# 9.URL, URI, URN kavramlarını bir örnek üzerinden açıklayınız.

* **URL (Uniform Resource Loader)**
    * Dilimize Tekdüzen Kaynak Bulucu ya da Kaynak Konumlayıcı şeklinde geçen yapıdır. İnternet aracılığıyla erişişebilecek kaynakların (dosyalar, dökümanlar vb.) konumu URL ile ifade edilir. URL teknik olarak URI’nın başlangıç kısmını oluşturur. Yapısal olarak, URL’in ardından ise URN gelmektedir. Ancak, bir konum belirtilmek istendiğinde çoğu durumda URI yerine URL ifadesi kullanılmaktadır. URI sözdizimi (syntax) şöyledir:
        * scheme://domain:port/path?query_string#fragment_id
        * scheme://user:password@host:port/path query_string#fragment_id


* **URI  (Uniform Resource Identifier)**

    * URI (Uniform Resource Identifier), kaynağa tam olarak tanımlayıcı (identifier) ile işaret eden (belge, resim, dosya vb.) ve bu işaretleme için standart bir formata sahip karakter dizgisidir. URL kapsamında tutulan alt tanımlardır. Bir sayfa, görsel, dosya vb. URI için örnek olabilir; http://ornekwebsitesi.com/logo.png, ISBN 0-486-27557-4 gibi. URI, URL ve URN olarak 2 kapsama sahiptir. Hem URN’ler (adlar) hem de URL’ler (konumlayıcılar) URI’lardır ve belirli bir URI aynı anda hem bir isim hem de konumlandırıcı olabilir.

* **URN (Uniform Resource studentNo)**
    * Bir kaynağı benzersiz ve kalıcı bir adla tanımlar, ancak bunu İnternet’te nasıl bulunacağının söylenmesi gerekmez. Belgeleri tanımlamakla sınırlı değildirler. Hatta, URN’ler fikirleri ve kavramları tanımlayabilir. Bir URN genelde urn: prefix’i ile başlar.

        * urn:isbn:0451450523 ISBN ile bir kitabı işaret eder.
        * urn:uuid:6e8bc430-9c3a-11d9-9669-0800200c9a66 global olarak benzersiz bir tanımdır.
        * urn:publishing:book bir belgeyi kitap türü olarak tanımlayan bir XML ad alanıdır.

# 10. Idempotency nedir ? Hangi HTTP metotları idempotent’tir ?

*Bir metodun bir defa çağrıldığında alınan sonuç ile birden fazla kez çağrıldığında alınan sonuç aynı ise bu bir idempotent metottur.*

Örnek verecek olursak: 
```
public void a(){
    i = 50;
}

public void b(){
    i = i + 1;
}
```

*“a” metodu bir kez çağrıldığında “i” değişkeninin değeri 50 olacaktır. Biz kez daha çağrıldığında sonuç değişmeyecektir.*
*“b” metodu bir kez çağrıldığında “i” değişkeninin değeri kaç ise bir fazlası olacaktır. Örneğin “i” nin ilk değeri 20 ise ilk kez çağırdığımızda değeri 21 olacaktır. Bir kez daha çağırırsak “i” nin değeri 22 olacaktır.*

*Bu durumda “a” metodu **idempotent**, “b” metodu ise **non-idempotent** metottur.*

### HTTP metotları

> GET, POST, PUT ve DELETE metotlarıdır. Bunların dışında başka metotlarda vardır ama en çok kullanılan metotlar bunlardır.


*Örnek olarak veritabanımızda aşağıdaki üç kayıt olsun.*

```
‘id’:1, ‘studentNo’:1952852, ‘studentName’:’Ali’
‘id’:2, ‘studentNo’:1239888, ‘studentName’:’Veli’
‘id’:3, ‘studentNo’:3241345, ‘studentName’:’Akın’
```

* GET
    * Sunucuya `` /students/1 `` şeklinde bir istek gönderdiğimizde, id si 1 olan kayıt dönecektir. Bu isteği birden fazla kez tekrarlamamız sonucu değiştirmeyecektir. Bundan dolayı GET idempotenent bir metottur.
* PUT
    * ``/students/1 ``
    ``body: {‘studentNo’:1239890, ‘studentName’:’VeliD’}`` 
    * Sunucuya yukarıdaki gibi bir istek gönderdiğimizde 1239888 Veli ifadesi 1239890 VeliD olarak güncellenecektir. İsteği bir kez daha gönderdiğimizde veritabanındaki değer 1239890 VeliD olduğunda bir değişiklik olmayacaktır. Bu da idempotenent bir metottur.
* DELETE
    * ``/students/1``
    * Sunucuya yukarıdaki gibi bir istek gönderdiğimizde id si 1 olan kayıt silinecektir. İlgili istediği tekrar çağırdığımızda id si 1 olan bir kayıt olmadığından herhangi bir işlem gerçekleşmeyecektir. Bu da idempotenent bir metottur.
* POST
    * ``/students ``
    ```body: {‘studentNo’:9852222, ‘studentName’:’Halay’}```
    * Sunucuya yukarıdaki gibi bir istek gönderdiğimizde, {‘id’:4, ‘studentNo’:9852222, ‘studentName’:’Halay’} şeklinde bir kayıt oluşacaktır. İlgili isteği bir kez daha çağırırsak {‘id’:5, ‘studentNo’:9852222, ‘studentName’:’Halay’} şeklinde bir kayıt daha oluşacaktır. Yani kaç defa çağırırsak o kadar yeni kayıt oluşacaktır. Bundan dolayı POST non-idempotenent bir metottur.



<img src="https://yigitoguzcom.files.wordpress.com/2019/07/screen-shot-2019-07-10-at-14.50.45.png" alt="drawing" width="400" height="200"/>


# 11.RFC (Request For Comment) neyi ifade etmektedir ? HTTP hangi RFC dokümanında açıklanmıştır ? Bu dokümanda HTTP hakkında ne tür bilgiler yer almaktadır ?

*İnternet standartlarına verilen tanımlamalara RFC denir. Her internet protokolü için bir RFC(Request for Comment) vardır. Örneğin, TCP/IP’ye adını veren TCP/IP RFC 793’de, Telnet RFC 854’de HTTP 1.0 RFC 1945’de ve SMTP RFC 821’de tanımlanmıştır. **[Tüm listeye buradan ulaşabilirsiniz](https://en.wikipedia.org/wiki/List_of_RFCs)***

* 2016 Yılından önce tek döküman ile açıklanan protokol artık 6 protokole çıkmıştır. Bunlar isimleri ve hangi bilgiler içerdiği aşağıda verilmiştir.   

    * RFC 7230	Hypertext Transfer Protocol (HTTP/1.1): Message Syntax and Routing
    * RFC 7231	Hypertext Transfer Protocol (HTTP/1.1): Semantics and Content
    * RFC 7232	Hypertext Transfer Protocol (HTTP/1.1): Conditional Requests
    * RFC 7233	Hypertext Transfer Protocol (HTTP/1.1): Range Requests	
    * RFC 7234	Hypertext Transfer Protocol (HTTP/1.1): Caching	 
    * RFC 7235	Hypertext Transfer Protocol (HTTP/1.1): Authentication	
