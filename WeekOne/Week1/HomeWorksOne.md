# Pass by value, pass by reference kavramları nedir ?  Java’ ile ilişkili olarak açıklayınız.

*C/C++ gibi dillerde call by value , call by reference adı ile isimlendirilen kavramlar, metotlara parametre aktarılırken 2 farklı yaklaşım kullanır. C/C++ gibi programlama yapılarında bunlar pointerlar ile yapılırken java da nesneler üzerinden gerçekleşir. Pass by value yapısında yapılan değişiklikler sadece geçilen nesne/obje sınırlı kalırken referancelar üzerinde yapılan değişiklikler değiştirilebilir. Çünkü aynı objeyi işaret ederler ve tek bir obje üzerinde değişiklik yapılır.
İlkel olmayan veri tiplerinde değişkenler genellikle bir objede tutulur ve böylece nesne/obje değişkenleri elden ele aktarılır.*

***Java’da değişken geçirme konusuyla ilgili olarak, basit ve genele bir ifade vardır:***

> Java'da her zaman pass by value yaklaşımı uygulanır.

<img src="https://i0.wp.com/www.realpythonproject.com/wp-content/uploads/2021/03/pass-by-reference-vs-pass-by-value-animation.gif?fit=500%2C270&ssl=1" alt="drawing" width="455"/><img src="https://i.ibb.co/v1857L9/Screenshot.png" alt="drawing" width="380"/>

# Immutability nedir, neden önemlidir ? Bir Java sınıfı nasıl immutable yapılır ?


*Kelime anlamı ve kullanım açısından Immutability değişmez, değişmeyen anlamına gelmektedir. Java'da kullanım amacı ise nesneleri bir kez oluşturulduktan sonra içeriği değiştirilemeyen sınıflardır için kullanılan yapıdır.*

*Immutable nesnelerin önemi ise Multi-thread ortamlarda ve streamlerde kullanışlıdır. Başka bir thread’in nesnesini değiştiren bir iş parçacığının neden olduğu hatalar olabilir. Immutable nesneler, bu sorunların tümünü çözmüş olacaktır.*

- Bir java sınıfı nasıl immutable yapılır ?
  - Sınıfı, final anahtarı ile işaretlemek gerekir, böylece genişletilemez (extend edilemez).
  - Sınıfın tüm alanlarını private yapın, böylece doğrudan erişime izin verilmez.
  - Değişkenler için setter yöntemleri sağlamayın.
  - Tüm değiştirilebilen alanları final yapın, böylece yalnızca bir kez atanabilir.
  - Tüm alanların, contructor aracılığıyla ilk değerlerini atamasını sağla.

> "Classes should be immutable unless there’s a very good reason to make them mutable….If a class cannot be made immutable, limit its mutability as much as possible." Effective Java Book.


# Framework ve library arasındaki fark nedir ?

*Basit bir örnek ile anlatacak olursak, Library evinizi sıfırdan inşa etmek gibidir, evinizi istediğiniz gibi yapma seçeneğiniz vardır, istediğiniz mimari ile odalarınızı istediğiniz gibi sıralayabilirsiniz.
Öte yandan, Framework yeni bir ev satın almak gibidir, bina sorunlarıyla uğraşmak zorunda kalmazsınız, ancak odalarınızı nasıl inşa edeceğinizi seçemezsiniz çünkü ev zaten inşa edilmiştir.*

<img src="https://i.ibb.co/nBjrFX5/Screenshot.png" alt="drawing" width="380"/>

> "Framework bir yazılım mimarisi içinde geliştirilen özelleştirilmiş librarylerdir."

# Java’da Garbage Collector’ un görevi nedir ?

*Garbage Collection, otomatik bellek yönetimi mekanizmasıdır. Bu işlem heap belleğe bakıp, kullanılan objelerin tespit edilmesi ve referans edilmeyenlerin silinmesi üzerine kuruludur. Kullanılmayan/referans edilmeyen nesnelerin kapladığı alan bellekte boşa çıkarılır ve bellekte boş yer açılmış olur. Bu işlemi yapan mekanizmaya da Garbage Collector denir.*

<img src="https://www.journaldev.com/wp-content/uploads/2017/11/G1-GC-cycle.png" alt="drawing" width="380"/>

# Memory leak nedir ? Java’da memory leak oluşması mümkün müdür ?

*Bellek sızıntısının standart tanımı, nesneler artık uygulama tarafından kullanılmadığında ortaya çıkan bir senaryodur, ancak GC (garbage collector) bunları çalışma belleğinden kaldıramaz, çünkü bunlara hala başvurulmaktadır. Sonuç olarak, uygulama gittikçe daha fazla kaynak tüketir ve sonuçta program crash olur.*

- Javada memory leak oluşması mümnkündür bunlara yol açan nedenler şöyle özetlenebilir.
  - İstenmeyen Nesne Başvurusunu Kullanma: Bunlar artık gerekmeyen nesne başvurularıdır. Başka bir nesne hala bu istenmeyen nesneye başvurduğundan, GC (garbage collector) belleği geri alamadığı zaman oluşur.
  - Uzun ömürlü Statik Nesnelerin Kullanılması: Statik nesnelerin kullanılması da bellek sızıntısına neden olur. Çünkü uygulama ömrüne kadar hafızada yaşarlar.
  - Yerel Sistem Kaynaklarının Temizlenememesi: Java'ya harici bir işlev tarafından ayrılan yerel sistem kaynakları. C ve C ++ ile yazılmıştır. JNI API'leri, yerel kitaplıkları Java koduna gömmek için kullanılır.
  - Üçüncü Taraf Kitaplıklarındaki Hatalar: AWT ve Java Swing paketlerindeki hatalar bellek sızıntısının bir başka nedenidir.

<img src="https://www.baeldung.com/wp-content/uploads/2018/11/Memory-_Leak-_In-_Java.png" alt="drawing" width="420"/>



# Yeni Java sürümleri ne sıklıkla çıkmaktadır ?

*Oracle, altı ayda bir gelen yeni Java Geliştirme Kiti (JDK) ve her üç yılda bir güncellenen uzun vadeli bir destek (LTS) sürümüyle standart Java'nın sürümlerini yayınlama kararı almıştır.*


# Stack ve Heap nedir ? Java’da hangi yapılar stack ile, hangi yapılar heap ile ilişkilidir ?

*Stack ve Heap kavramlarından kısaca bahsetmek gerekirse, ram’in mantıksal bölümleridir diyebiliriz. Stack’de değer tipleri, pointer ve adresler saklanırken, Heap’de ise referans değerleri saklanmaktadır.*

*Stack’e erişim Heap’den daha hızlıdır ve Stack, LIFO (Last-In-First-Out) mantığında çalışmaktadır. Yani son gelen ilk olarak çıkar. Bu sebep ile aradan herhangi bir eleman çıkartamazsınız, birbirleri ile ilişki içerisindedirler.*

- **Veriler Nerede Saklanır?**
  - Tüm nesneler heap alanında depolanır. Örnek değişkenler(instance variables) de nesneye ait olduklarından heap alanında depolanır.
  - Tüm local değişkenler yığın (stack) da depolanır. Sınıf değişkenleri (yani static tanımlanmış değişkenler) Java 7'de heap bölgesi içinde yer alan PermGen (Permanent Generation) adı verilen özel bir alanda depolanıyor.
  - Java 8 ile birlikte PermGen alanı kaldırıldı. Oracle HotSpot JVM, artık sınıf metadatalarını Java Process Heap(Native Memory) alanında yer alan Metaspace alanında depoluyor.
  - Özetlersek static tanımlanmış değişkenler Java 8 de native memory içinde **Metaspace** alanında, Java 7'de heap bölgesi içerisinde yer alan PermGen alanında depolanıyor.

<img src="https://lh3.googleusercontent.com/proxy/9FULYSrG2EqNq5AI3UXvWHe-b7kXXLSbCReCXPZ3sDtHoIFGDZ1dGE_C8op0JKuT8X70qrQwn-hxvPkN0SgdB1Z79DXqi1_9JpBU9-yl593I=w1200-h630-p-k-no-nu" alt="drawing" width="400"/>


# OpenJDK ve OracleJDK arasındaki farklar nelerdir ?

*OpenJDK ve Oracle JDK arasındaki en büyük fark lisanslamadır. OpenJDK, GNU Genel Kamu Lisansına sahip tamamen açık kaynaklı bir Java'dır. Oracle JDK, Oracle İkili Kod Lisans Sözleşmesi kapsamında ticari lisans gerektirir. Ancak destek ve maliyet açısından da başka birçok farklılık var.*

*Oracle JDK performansı openjdk'dan daha iyiydi, ancak bu değişiyor. Openjdk'nın performansı sürekli gelişiyor. OpenJDK yapıları, OpenJDK topluluğunun katkılarıyla daha istikrarlı hale geliyor ve kurumsal destekle birleştirildiğinde, OpenJDK performansı  oraclejdk'ya göre daha önde geliyor.*


# @FunctionalInterface anotasyonu nerelerde kullanılabilir, neleri sağlar ?

*Fonksiyonel olması beklenen arayüzlere birden fazla metot eklemehatasına düşmemek için, o arayüzün fonksiyonel olması gerektiği java.lang.FunctionalInterface notu (annotation) ile ifade edilebilir.*

*Zorunlu değildir, bilgi vermek ve hatadan korumak için kullanılır.*

*Fonksiyonel olması beklenen arayüzde **``@FunctionalInterface``** kulanılması, arayüze birden fazla metot yazılması engellenir.*

*Birden fazla metot yazılması durumunda Java derleyicisi o arayüzde hata verecektir.*


# Java’da hangi functional interface’ler yer almaktadır ? Yaptığınız araştırmada en popüler/göze çarpanlar hangileridir ?

*Java çeşitli  amaçlarla, kendi APIsindeki farklı ihtiyaçlara cevap vermek için en temel fonksiyonel arayüzleri java.util.function paketinin altında tanımlamıştır.*

**Java 8’de java.util.function paketinde toplam 43 tane hazır fonksiyonel arayüz ya da fonksiyon vardır.**

<img src="https://i.ibb.co/1Rj3rQL/Ads-z.png" alt="drawing" width="480" />

- **java.util.function paketinde 4 tane temel hazır arayüz ve
  üzerindeki soyut metotlar şunlardır:**

  - ``Function<T,R>: R apply(T t)``
  - ``Supplier<T>: T get()``
  - ``Consumer<T>: void accept(T t)``
  - ``Predicate<T>: boolean test(T t)``

*Bu 4 temel hazır arayüzün, Supplier dışında diğer 3 tanesi için, ismi Bi ile başlayan ve aynı işi iki argüman için yapan halleri ve üzerindeki soyut metotlar şunlardır:*

```
- BiFunction<T,U, R>: R apply(T t, U u)
- BiConsumer<T, U>  : void accept(T t, U u)
- BiPredicate<T, U> : boolean test(T t, U u)
```

*Ayrıca, Function<T, R>’nın alt arayüzü **UnaryOperator`<T>`** ve BiFunction<T, R, U>’nın alt arayüzü **BinaryOperator`<T>`** vardır.*

*UnaryOperator`<T>`, Function<T, R>’nın argüman ve dönüş tipi aynı olacak şekilde özelleşmiş hali iken, BinaryOperator`<T>` de BiFunction<T, R, U>’nın aynı tipten iki argüman alıp aynı tipten değer döndürecek şekilde özelleşmiş halidir.*

- *UnaryOperator`<T>` ve BinaryOperator`<T>` üzerindeki soyut metotlar şunlardır:*

  - ``UnaryOperator<T>: T apply(T t)``
  - ``BinaryOperator<T>: T apply(T t1, T t2)``

*En çok kullanılan ve en temel hazır arayüzler ve özellikleri şunlardır:*

<a href="https://ibb.co/qYgvkj0"><img src="https://i.ibb.co/gZWxz9v/Ads-z.png" alt="Ads-z" border="0" />

# **Ali CANLI - Patika.dev Spring BootCamp HomeWork-1**
