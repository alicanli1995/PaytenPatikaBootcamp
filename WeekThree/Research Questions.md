# 1. Imperative Programming ve Declarative Programming kavramlarını kısaca açıklayıp farklarını belirtiniz.

* **Imperative Programming (Emirli Programlama)**

*Bilgisayar bilimlerinde, programlama dillerini sınıflandırmak ve bir programlama dilinin özelliklerini belirtmek için kullanılan bir terimdir. Genellikle literatürde prosedürel programlama (procedural programming) olarak da geçmektedir.*

*Emirli programlama ile kastedilen, bir programlama dilindeki komutların satır satır emirlerden oluşmasıdır.* 

*Örneğin bir robota komut verecek olsaydık:*

```
Kolu 10 derece sağa döndür
2 metre yürü
Kolu 20 derece sola döndür
```

* **Declarative Programming (Deklaratif Programlama)** 

*Ne yapılacağını içeren, nasıl yapılacağınının mantığını pek de içermeyen paradigmadır. CSS veya HTML’i düşünün. Bir şeyin blur olacağını ifade edersiniz browser blur yapar. O şeyin nasıl blurlaştırılacağı hakkındaki fizik mantığını kurgulamaya çalışmazsınız. Veya border atadığınızda, onun aslında bir piksellik bir çizgi olduğunu, çizginin aslında noktalardan meydana geldiğini filan açıklamaya çalışmazsınız. Ne yapılacağını söylersiniz, yapılır.*

```
function createWidget(type, txt) {
  return new Element(type, txt);
}
```

*Mesela burada fonksiyon bir widget yaratıp geri döndürmüş. Widget’ın nasıl yaratıldığı hakkında çok fazla bilgimiz yok. Belki gerek de yok. Widget istedik widget’ı aldık.*

<img src="https://miro.medium.com/max/700/1*c1KtkZhRpnL8i_GpLT4fuQ.png" alt="drawing" width="455"/>



# 2. Veri tabanlarının sorgu optimizasyonlarında index oluşturmanın avantajı nedir ? Sık index kullanmak bir probleme yol açar mı?

*Veri tabanlarında sorgu optimizasyonunda index oluşturmanın en büyük avantajlarından biri doğru index kullanımı ile istenilen veriye hedef tablonun tamamını okumaya gerek kalmadan daha kısa bir sürede ulaşabilmektir.*

*Sık kullanmanın bir probleme yol açabileceği durumları gözlemleyemedim.*


# 3. İlişkisel veritabanları için normalizasyon kavramı neyi ifade etmektedir ? İlk 3 normal formu örnek üzerinden açıklayınız.

*Normalizasyonun iki temel amacı vardır. Veri tabanında veri tekrarlarını ortadan kaldırmakveveri tutarlılığını (doğruluğunu) artırmak.*

*Normalizasyon, veri tabanlarına seviyelerle (normal formlar)uygulanır.*

*Bir veri tabanının bu normal formlardan herhangi birine uygun olduğunu söyleyebilmek için, söz konusu normal formun tüm kriterlerini eksiksiz yerine getiriyor olması şarttır.*

> 1NF (1. Normal Form)

* Bir veri tabanının 1NF olabilmesi için aşağıdaki özellikleri karşılayabilmesi gerekir:
    * Aynı tablo içindetekrarlayan kolonlar bulunamaz,
    * Her kolonda yalnızca bir değer
    * Her satır bir eşsiz anahtarla tanımlanmalıdır (Unique Key -Primary Key)

<a href="https://imgbb.com/"><img src="https://i.postimg.cc/mZwRdqLN/image.png" alt="Ads-z" border="0" width ="600" /></a>


> 2NF (2. Normal Form)

* İkinci normal formun ilk normal form üzerinde tek kuralı vardır. O da anahtar olarak tanımlanabilecek bir anahtara bütün diğer kolonların tam bağlı olması ve herhangi bir alt kümesine bağlı olmamasıdır.

1NF olan aşağıdaki tabloyu 2NF’e dönüştürelim.

<a href="https://imgbb.com/"><img src="https://i.postimg.cc/FFP8kQFq/Screenshot.png" alt="Ads-z" border="0" width ="600" /></a>

> 3NF (3. Normal Form)

* Bir veri tabanının 3NF olabilmesi için aşağıdaki özellikleri karşılayabilmesi gerekir:
    * Veri tabanı 2NF olmalıdır,
    * Anahtar olmayan hiç bir kolon bir diğerine (anahtar olmayan başka bir kolona) bağıl olmamalı ya da geçişken fonksiyonel bir bağımlılığı (transitional functional dependency) olmamalıdır. Başka bir deyişle her kolon eşsiz anahtara tam bağımlı olmak zorundadır.
    * Veri tekrarını azaltmak için tanım tabloları oluşturulur.

Veri tabanımızı 3NF şartlarına uydurabilmek için anahtar olmayan ve eşsiz anahtara tam bağımlı olmayan tüm kolonları kaldırmalıyız.

<a href="https://imgbb.com/"><img src="https://img.onl/6vCj1m" alt="Ads-z" border="0" width ="600" /></a>

<a href="https://imgbb.com/"><img src="https://img.onl/eGFDRM" alt="Ads-z" border="0" width ="600" /></a>



# 4. ORM kütüphaneleri kullanmak her zaman avantajlı mıdır ? ORM kütüphanelerinin ne gibi dezavantajları olabilir ?

*ORM’den bahsederken çoğu yazılım geliştirici Object-Relational Mapping tekniğini uygulayan bir kütüphaneye ihtiyaç duyar.*

*Bir ORM kütüphanesi , kullandığınız programlama dilinde verileri içeri çekerek onları manipüle edip nesnelere dönüştürmektedir , yani artık sql kullanmanıza gerek kalmıyor . Kullanmakta olduğunuz dilde veritabanı ile doğrudan iletişime geçersiniz.*

* ORM Tekniğinin Dezavantajları

    * ORM teorisini ve tekniğini öğrenmek zaman alabilir. ORM kütüphaneleri oldukça karmaşık kütüphanelerdir.
    * ORM araçlarının, konfigurasyonlarının yapılması ve uygulamaya entegre edilmeleri gereklidir. (Bu entegre işlemi başka frameworkler ile hızlı ve kolayca halledebilebilir. Örnek olarak, Java için Spring Framework özellikle Spring Boot ve Spring Data kullanılabilir)
    * Yüksek performans gerektiren veya kompleks sorgular barındıran uygulamalarda, ORM sorguları optimize edilmezse düşük performans sunabilir.


# 5. Domain Specific Language (DSL) kavramını açıklayınız.

*Domain Specific Language(DSL) belli bir sorun alanı, belli bir sorunu sunuş tekniği, ve/veya belli bir çözüm tekniği için belirlenmiş bir programlama dili ya da belirtim dilidir.*

*Genel bir programlama dilinden ziyade, özel bir konu icin geliştirilmiş bir programlama diline denir. Yacc, lex gibi scanner ve parser dilleri, ya da sql gibi bir database dili örnek olarak verilebilir. Farklı örnek verecek olursak: boolean algebra islemleri yapmaya yarayan bir dil, set theory language, web server performance profiling, vs. olabilir. Yani akla gelebilecek her türlü iş icin özelleştirilmiş dillere domain specific language adi verilir. Amacı programlamayi kolaylaştırmak, çogu kez de performansı arttırmaktır.*

# 6. Long lived transaction kavramı hangi tip transactionları ifade etmektedir ? Dezavantajları var mıdır ? Varsa nelerdir ?

Beggin, commit ve rollback gibi transactionları ifade etmektedir.

* Dezavantaj olarak; 

    * Long lived transaction, concurrency  ve scability sorunları yaratır.


# 7. Thread Pool nedir ? Nerelerde kullanılır ?

*Threadler birçok konuda bize fayda sağlamasının yanında kontrolsüz bir şekilde kullanıldığı takdirde baş ağrıtan bir konudur. Threadler aynı zamanda işletim sisteminin kaynaklarını kullandıkları için kontrolsüz bir şekilde kullanıldığında bu kaynakları hızlıca tüketmiş oluruz.
Örnek vermek gerekirse, donanımsal olarak 2 işlemci çekirdeğimiz mevcut olduğu bir ortamda 4 thread çalıştırmak gerekse bile önce ilk 2 sinin bitmesini bekleyip daha sonra diğer 2 sini oluşturup çalıştırmalıyız. Bu olayı bu şekilde takip etmek yerine Java nın bize sağladığı Thread havuzlarını kullanabiliriz. Thread sayısının ve çalışmasının düzenli ve kontrollü bir şekilde gerçekleştirilmesi için Java bize Executor adında bir sınıf sunmaktadır.*

* Kullanımını kısaca özetleyecek olursak:

    * ExecutorService bize belli bir anda en fazla kaç Thread çalıştırmak istediğimizi sormaktadır.
    * newFixedThreadPool() methodu ile bu sayı belirtilebilir.
    * ExecutorService.submit() metodu ile threadlerimizi executorService e ekleriz.
    * “ExecutorService” havuzunda yer olduğu sürece kendisine eklenen Runnable nesneleri ile yeni birer thread oluşturur ve onu başlatır.
    * Sonradan eklenen işlemler sıraya (queue) sokulur ve mevcut işlemler bitirildikçe çalıştırılır.
    * shutdown() metodu ise yeni işlem alımını durdurur ve mevcut işlemlerin bitirilmesini sağlar.
    * awaitTermination() ise mevcut işlemlerin bitirilmesi için belirli bir süre tanır ve bu sürenin sonunda ExecutorService tamamen kapatılır.

# 8. Scalability nedir ? Horizontal ve Vertical Scalability kavramlarını açıklayınız.

*Ölçeklenebilirlik programlama dillerine has bir kavram değildir. Sistemdeki artan kullanıcı sayısıyla birlikte sistemin bu artışa nasıl bir tepki verdiği ile ilgilidir. Sistem alt yapısı hitap ettiği kullanıcı sayısına göre tasarlanması gereklidir. Örneğin androidde bir program yazdınız verilerinizi ise 100-200 kullanıcının yapacağı requestleri kaldırabilecek bir sistemde tutuyorsunuz, bu programı play store dan 10.000 kişi indirip kullanmaya başladığında sistem requestlere cevap veremez hale gelecektir. Bu sorunların önüne geçmek için ise günümüzde Amazon, Azure gibi Cloud servisleri vardır. Ne kadar kullanıcı bağlanır , ne kadar request yapılırsa request başına ödeme yapılmaktadır.*

* Horizontal Scability & Vertical Scability

    * Dikey ölçeklenebilirlik varolan makinenizin CPU, RAM gibi özelliklerini artırarak daha güçlü hale getirilmesidir. Yatay ölçeklenebilirlik ise varolan kaynak havuzunuza daha fazla makine eklenmesidir. Yatay ölçeklenebilirlikte load balancer kullanımıyla sistemin yükü tüm makinelere eşit şekilde dağıtılır.

    * Yatay ölçeklenebilirlikle dinamik olarak varolan kaynak havuzuna yeni makine eklemek daha az maliyetli, daha kolaydır ve istenildiği kadar ekleme yapılabilir. Dikey ölçeklenebilirlikte ise bir makineye ekleyebileceğiniz özellikler için üst sınır vardır. Yani tek makinenin artırılabileceği özelliklerini belirli bir noktaya kadar artırabilirsiniz.

# 9. Data replication ve sharding nedir ? Aralarında nasıl bir fark bulunmaktadır ?

*Sharding, performansı ve okuma süresini iyileştirmek için veritabanının birden çok daha küçük veritabanına bölündüğü bölümlemedir. Replication, daha hızlı bir görünüm ve daha az yanıt süresi sağlamak için temel olarak veritabanını birden çok veritabanına kopyalama eventine denir. Content delivery ağları bunun en iyi örnekleridir.*