# Collection Pipeline

*Collection Pipeline, fonksiyonel programlama da yaygın olarak kullanılan bir design pattern olarak görülüyor. 
Yapısı ise bir fonksiyonun çıktısını alıp bir sonra ki fonksiyonu feedleyerek oluşan işlemler dizisi ile tanımlanabilir.* 


<img src="https://i.ibb.co/35X9mp2/Screenshot.png" alt="drawing" width="380"/>

# First encounters

*Burada bahsedilen genel konu ise OOP dilinin bir eksikliği gibi görülen ve bu konu hakkında sıklıkla dile getirilen fonksiyonel programlamaya izin vermeyen yapısının getirdiği sıkıntılardan bahseiliyor tabi bunlar lambda ifadeleri java'ya eklenmeden önce olan zamanlar için geçerli. Java'dan önce ki programlama dillerinin bazılarının Smalltalk gibi, sağlam fonksiyonel proglama algoritmalarına izin verdiğini bu durumun java'ya geçildiği ilk zamanlarda büyük bir eksiklik olarak görüldüğü, geçerli çözümler üretmek istediklerini ama bunda pek başarılı olamadıkları bahsedilmektedir.*

# Defining Collection Pipeline

*Burada oluşan patternin tanımı gibi bir konudan bahsedilmiştir. Yapılan her girdinin bir işlem olarak bir Collection aldığını ve buna bağlı başka bir Collection'a gönderdiği gerekli map, filtreleme vs gibi çeşitli ve karmaşık işlemleri yaptıktan sonra bir çıktı üreteceğinden bahsediliyor. Nesneye yönelimli programlamada kullanılan Collectionsların list, array, set gibi sınıflardan türetildiğinden bahsedilmektedir.* 

# Exploring more pipelines and operations

Burada ise boru hatları dizaynında kullanılan yani Collection pipeline'larda kullanılan fonskyionlardan bahsedilmiştir. Bu fonksiyonlardan bazılarını birleştirip işlevsel bir fonksiyon haline getirerek örneklendirilmiştir.

##### Getting total word counts (map and reduce) -> Toplam kelime sayısını alma
<a href="https://ibb.co/q1kSmzJ"><img src="https://i.ibb.co/PCwL1RD/Screenshot.png" alt="Screenshot" width=380 /></a>

*Yazar burada örneği, rubya dili göstermiştir. Ruby'de ki map fonksiyonuna karşılık gelen java fonksiyonu streamlarda yer alan map fonksiyonudur. Fonksiyonun kullanım amacı ise bütün öğeleri erişmek ve gerekli değişikliği sağlamaktır. Örnekte bütün değerlere erişilmiş ve değerlerin karesi alınmıştır.*

```[1, 2, 3].map{|i| i * i} # => [1, 4, 9] ```

*Örnekte gösterildiği gibi dizinin her öğesine ulaşıp her bir elemanın karesini almaktadır.*

```[1, 2, 3].reduce {|acc, each| acc + each} # => 6```

*Burada ise bütün elemanların toplamını reduce fonksiyonu ile yapmış oluruz*

*Aslında bu iki fonksiyonu kullanarak toplam kelime sayısını alabiliriz.*

```
some_articles
    .map{|a| a.words}
    .reduce {|acc, w| acc + w}
```
*İlk adım, listeleri sözcük sayısı listesine dönüştüren map fonskyionudur. İkinci adım, toplamı oluşturmak için sözcük sayısı listesinde bir reduce fonksiyonu çalıştırır.*

##### Getting the number of articles of each type (group-by) -> Her türden makale sayısını alma (gruplandırmaya göre)
<a href=""><img src="https://i.ibb.co/2tLrt1x/Screenshot.png" alt="Screenshot" width=380 /></a>


*Bunu yapabilmek için önce makale listemizi makalenin türüne göre gruplandırmamız gerekir. Burada birlikte çalışılacak toplama fonksiyonu grup bazında bir işlemdir. Bu işlem, öğeleri, sağlanan kodun o öğe üzerinde yürütülmesinin sonucu tarafından dizine eklenen bir karma grup içine koyar. Makaleleri kaç tane etikete sahip olduklarına göre gruplara ayırmak için bu işlemi kullanılmıştır.*

```
some_articles
  .group_by {|a| a.type}
```
*Bundan sonra ki yapılan aşamasa ise makaleleri saymak. İlk bakışta, bu sadece makale sayısını saymak için map işlemi basit bir görevdir. Ancak buradaki komplikasyon, her grup için iki tip veri döndürmemiz gerektiğidir: grubun adı ve sayısı. Daha basit, ancak bağlantılı bir sorun, daha önce gördüğümüz harita örneğinin bir değerler listesi kullanmasıdır, ancak group-by işleminin çıktısı bir hashmap'tir.*

*Bunu da Ruby dilinde aşada ki gibi gerçekleştirmiştir.* 
```some_articles
  .group_by {|a| a.type}
  .map {|pair| [pair[0], pair[1].size]}
  .to_h
```
*Bir listenin her bir öğesinin tam olarak nasıl temsil edildiği dilden dile değişir, ancak basit (ve yaygın) bir yaklaşım, her bir liste öğesini iki öğeli bir dizi olarak ele almaktır: [key, value]. Yani örnekte gösterilen pair[0] ve pair[1]'dir.*

##### Getting the number of articles for each tag -> Her etiket için makale sayısını alma
<a href=""><img src="https://i.ibb.co/jkV6q2P/Screenshot.png" alt="Screenshot" width=380 /></a>


*İlk adım olarak, etiketlerden başlamak gerekir, veri yapısını çözümlemek gerekir, böylece her etiket-makale kombinasyonu için bir kaydımız olmasını sağlarız. Bunun, bir ilişkilendirme tablosu kullanarak ilişkisel bir veritabanında many-to-many ilişkisi kurularak tanımlanabilir. Bunu yapmak için bir makale alan ve her etiket ve makale için bir çift (iki öğe dizisi) yayan bir lambda oluşturulmuştur. Daha sonra bu lambda'yı tüm makalelerde map fonskyionu ile gezilerek pipeline tamamlanmıştır.*

```some_articles
  .map {|a| a.tags.map{|tag| [tag, a]}}   
```

*Bu kodun üreteceği yapı ise şu şekilde tanımlanabilir.*

```
[
  [ [:nosql, Article(NoDBA)]
    [:people, Article(NoDBA)]
    [:orm, Article(NoDBA)]
  ]
  [ [:nosql, Article(Infodeck)]
    [:writing, Article(Infodeck)]
  ]
  # more rows of articles
]
```

*Haritanın sonucu, her makale için bir iç içe liste içeren çiftlerin bir listesidir. Bunu da Java'da da metodunu yazdığımız reduce fonksiyonu ile tek bir liste haline getirebiliriz.*
```
some_articles
  .map {|a| a.tags.map{|tag| [tag, a]}}   
  .flatten 1
```
*Bu kodun sağladığı çıktı ise aşağıda gösterildiği gibi olur.*

```
[
  [:nosql, Article(NoDBA)]
  [:people, Article(NoDBA)]
  [:orm, Article(NoDBA)]
  [:nosql, Article(Infodeck)]
  [:writing, Article(Infodeck)]
  # more rows of articles
]
```

*Biz burada map ve flat işlemlerini pipeline sırasına sokup yaptık ama bu işlem fonksiyonel programlama dünyasında o kadar yaygın kullanıma sahiptir ki bunun için ikisini de barındıran ayrı bir fonksiyon yazılmıştır. Bu fonksiyonun adı **"flat_map"** olarak tanımlanmaktadır.*

*Aslında yazdığımız kodu tek satıra bu fonksiyon sayesinde indirebiliriz.*

```
some_articles
  .flat_map {|a| a.tags.map{|tag| [tag, a]}} 
```
*Artık elimizde bir çift liste var bunu da groupBy fonksiyonu ile gruplandırmak çok daha basit bir iş artık.*

```
some_articles
  .flat_map {|a| a.tags.map{|tag| [tag, a]}}
  .group_by {|pair| pair.first}
```

*Bu pipelinedan elde edeceğimiz çıktı ise:*

```
{
  :people:
    [ [:people, Article(NoDBA)] ]
  :orm:
    [ [:orm, Article(NoDBA)]
      [:orm, Article(OrmHate)]
    ]
  :writing:
    [  [:writing, Article(Infodeck)] ]
  # more records
}
```

*Bu şekilde olur, fakat halen istediğimiz çıktıyı alamamaktayız. Bu daha önce de karşılaştığımız iç içe dizi sorunuyla ayrı sorun bunuda tekrardan map  kullanarak tek bir dize haline getirebilirim.*

```
some_articles
  .flat_map {|a| a.tags.map{|tag| [tag, a]}}
  .group_by {|pair| pair.first}
  .map {|k,pairs| [k, pairs.map {|p| p.last}]}   
```

*Bu kodun çıktısı da aşada ki gibi olur.*

```
{
  :people:    [ Article(NoDBA) ]
  :orm:       [ Article(NoDBA), Article(OrmHate) ]
  :writing:   [ Article(Infodeck) ]
  # more records
}
```

*Gerekli sonuçları üretmek için artık son bir adımımız kaldı, ihtiyacımız olan tam verileri çıkarmak için basit bir map fonksiyonundan ibaret.*

```
some_articles
  .flat_map {|a| a.tags.map{|tag| [tag, a]}}
  .group_by {|pair| pair.first}
  .map {|k,pairs| [k, pairs.map {|p| p.last}]}    
  .map {|k,v| [k, {articles: v.size, words: v.map(&:words).reduce(:+)}]}
  .to_h
```

*Artık elimizde istediğimiz gibi çıktı üreten bir pipeline desing ile tasarlanmış bir fonksiyonlar serisi var ve bu serinin üreteceği çıktı ise aşadaki gibi olacaktır.*

```
:nosql:
  :articles: 4
  :words: 3906
:people:
  :articles: 1
  :words: 561
:orm:
  :articles: 2
  :words: 2279
:writing:
  :articles: 1
  :words: 1145
:ruby:
  :articles: 1
  :words: 1313
:ddd:
  :articles: 1
  :words: 482
```

# Alternatives

*Şimdiye kadar gördüğümüz yapılar pipelinelar ile tasarlanmış yapılardı ama java'da da önceden kullanılan genellikle fonksiyonel programlama ile uğraşmak istemeyen insanlar için alternatif yollar vardır. Bunların başında basit döngü yapıları gelmektedir.*

#### Loops 

*Yazar burada NoSQL yapısı kullanarak fonksiyonel programlama yerine basit döngü yapıları ile nasıl yapılacağını göstermiştir.*

*Örnek olarak yukarı da ki pipelineda tasarladığımız gruplama işlemini ele alabiliriz.*

<a href="https://ibb.co/0tNfRtT"><img src="https://i.ibb.co/yST8cSt/Screenshot.png" alt="Screenshot" border="0" width=800 /></a>


*Görüldüğü gibi iki durumda da istenen çıktı elde edilebilmektedir fakat biri daha kısa ve anlaşılır bir yapıya sahipken diğer basit döngü kısmı uzun ve takibi zorlaşan bir yapıya sahiptir.*

#### Using Comprehensions

*Bazı diller, genellikle basit collection pipelinerları yansıtan liste kavramaları olarak adlandırılan kavramalar için bir yapıya sahiptir. Bin kelimeden uzun olan tüm makalelerin başlıklarını almayı düşününelim. Yazar burada javascript ile gösterilmiş, ancak Javascript'in collection pipelinelarını oluşturmak için kendi fonksiyonel programlama özellikleride kullanılabilir.*


<a href=""><img src="https://i.ibb.co/m4MpPk3/Screenshot.png" alt="Screenshot" width=800 /></a>


# Nested Operator Expressions

*Collectionslarla yapabileceğimiz fonksiyonel şeylerden biri, onları set işlemleriyle değiştirmektir. Örnek verecek olursak, Varsayalım ki bir otel bakıyoruz içerisinde bir fonksiyon var bize istediğimiz özelliklerde odaları geri döndüren mesela mavi, kırmızı, veya otelin önüne bakan odalar ya da dolu olan odalar. Daha sonra bunu bir nested operator kullanarak ifade edebiliriz.*

```
(front & (red | blue)) - occupied
```
*Bu ifadeyi collection pipelinelar ile yazmaya çalışırsak daha karmaşık bir hale getiririz aslında. Bu yüzden nested operatorler bazı kullanımlarda bizlere daha sadelik ve kolaylık sağlamaktadır.*

```
red
  .union(blue)
  .intersect(front)
  .diff(occupied)
```



# Laziness

*Tembellik kavramının, fonksiyonel programlama dünyasından geldiğinden bahsedilmektedir. 
Buna örnek şöyle bir kod olabilir:*

```
large_list
  .map{|e| slow_complex_method (e)}
  .take(5)
```

*Bu kod istediğimiz şey için aslında çok kısa bir tarama yapmamız gerekirken bütün dizeyi elden geçirmeyi kapsıyor, slow_complex_method değerlendirmek için çok zaman harcarız ve ardından ilk 5 dışındaki tüm sonuçları atarız. Tembellik, temel alınan gereksinimin yalnızca ilk beş sonucuna ihtiyacınız olduğunu belirlemesine ve ardından yalnızca ihtiyaç duyulanlar üzerinde slow_complex_method gerçekleştirmesine olanak tanır.*

*Bazı collection pipiline işlemleri tembellikle çalışamaz ve tüm listeyi değerlendirmek zorunda kalır. Sorting bir örnektir, listenin tamamı olmadan tek bir üst değer bile belirleyemezsiniz.*

# Parallelism

*Collection pipeline işlemlerinin çoğu doğal olarak paralel programlama ile iyi çalışır. Map kullandığımız bir pipelineda, bir öğe için kullanmanın sonuçları koleksiyondaki diğer öğelerden hiçbirine bağlı değildir. Bu nedenle, birden fazla çekirdeğe sahip bir platformda çalışıyorsak, map değerlendirmelerini birden çok iş parçacığına dağıtarak bundan yararlanabiliriz. Buda bizlere ciddi bir performans artışı verir ve zamandan tasarruf etmemize olanak sağlar.*

# Immutability

*Collection pipelinelar immutability veri yapılarına uygundur. Bir pipeline oluştururken, her işlemin çıktısı için yeni bir collection oluşturduğunu düşünmek doğaldır. Saf bir şekilde yapıldığında bu, büyük miktarda veriyle ilgili sorunlara yol açabilecek çok fazla kopyalama gerektirir. Ancak çoğu zaman pratikte bir sorun teşkil etmez. Genellikle büyük veri yığınları yerine daha küçük işaretçi kümeleri kopyalanır.Yazar burada kullanılması mümkün olduğu zaman kesinlikle immutability veri yapılarının kulllanılması gerektiğini, değişkenliğin getireceği hatalardan ve buglardan bu sayede kaçınabileceğimizden bahsetmiştir.*

# Debugging

*Yazar burada collection pipelineların hata ayıklama kısmının getirdiği zorluktan bahsetmiştir*

*Modern IDE'lerin hata ayıklamada yardımcı olabilecek çok fazla özelliği olduğunu ama Ruby gibi dillerin kullanıldığı idelerin resmen kullanıcılarla alay edercesine oluşturulmuş debug eksikliğinden bahsedilmektedir.*

# When to Use It

*Özellikle kullanılan dilin fonksiyonel progralama desteğinin olup olmadığının bilinmesi önemlidir. Java'nın lambda expressionlar gelmeden önce ki sürümlerinde collection pipelineları kullanmak çok zorlayıcı olabiliyordu bunlar döngüler ile sağlanabiliyordu ama yukarı da döngülerin kullanımlarının zorluklarından bahsetmiştik. Yazar burada uygun diller kullanılsa bile collection pipelineların bazen çok karmaşıklaşabileceğini bu durumdan kendisinin de kaçındığını aktarmıştır.*

*Yazar kendisine koyduğu kuralı şu cümlelerle anlatmaktadır;*


> Extract a method whenever there's a difference between **what** a block of code does and **how** it does it.




# Ali CANLI - Patika.dev Spring BootCamp HomeWork-2


