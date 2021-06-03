package com.example.bartendingbook

import android.app.Application
import android.content.res.AssetManager
import java.io.InputStream

class MyApplication: Application() {
    companion object {

        var listCocktails = ArrayList<Cocktail>()
        var cocktailsNum = 20

        fun getCocktailsInRange(start_id :Int,stop_id :Int) : ArrayList<Cocktail>{
            var listCocktailsById = ArrayList<Cocktail>()

            for (i in start_id..stop_id){
                listCocktailsById.add(listCocktails[i])
            }
            return listCocktailsById
        }

        fun getCocktailById(id : Int) : Cocktail{
            return listCocktails[id]
        }
    }

    override fun onCreate() {
        super.onCreate()

        val names =arrayOf<String>("Cosmopolitan","Wódka Sour","Jungle Juice","Portofino drink","Moscow Mule","Vesper Martini","Orang-A-Tang","Key West Cooler","Hard Lemonade","Black Russian","Whisky Sour","Manhattan",
        "Old Fashioned","Mint Julep","Rusty Nail","Opening Shot","Old Pal","Peat’s Dragon","PENICYLINA","Blood and Sand")
        val photos =arrayOf(R.drawable.photo0,R.drawable.photo1,R.drawable.photo2,R.drawable.photo3,R.drawable.photo4,R.drawable.photo5,R.drawable.photo6,R.drawable.photo7,
                R.drawable.photo8,R.drawable.photo9,R.drawable.photo10,R.drawable.photo11,R.drawable.photo12,R.drawable.photo13,R.drawable.photo14,R.drawable.photo15,
            R.drawable.photo16,R.drawable.photo17,R.drawable.photo18,R.drawable.photo19 )
        val desctiptions =arrayOf<String>("Tego koktajlu chyba nie musimy nikomu przedstawiać. Cosmopolitan to klasyczny kobieciarz, który swoją popularność zawdzięcza serialowi „Sex w Wielkim Mieście”. Poza tym, drink jest smaczny i prosty! Nie dziwi nas, dlaczego ma tylu fanów! To również świetna propozycja na imprezę.",
       "Czy to w klubie, czy w domowych warunkach, czy w plenerze… Koktajl Wódka Sour sprawdzi się idealnie w każdych okolicznościach. Drink jest smaczny, jego skład jest prosty, a przygotowanie zajmuje tylko chwilę. Koktajl Wódka Sour zazwyczaj dekorowany jest ćwiartką pomarańczy oraz wisienką koktajlową.  Ciężko znaleźć coś bardziej klasycznego niż Wódka Sour, prawda? Zajrzyjcie do naszego przepisu i przekonajcie się sami jak idealnie wpasuje się na każdą okazję! ",
"Jungle Juice to kolejny smaczny kandydat, na egzotyczny koktajl. Filarami tego koktajlu są wódka, biały rum oraz likier cointreau. Jego uzupełnienie to prawdziwa dżungla sokowa. W tym jednym drinku znajdziecie sok z limonki, pomarańczowy, żurawinowy oraz ananasowy. Koniecznie spróbujcie! ",
"Zacznijmy może od tego czym takim jest Portofino. To nie jest nazwa byle czego, tylko jednego z najpiękniejszych i zarazem najdroższych miasteczek na włoskiej riwierze. Piękny port jachtowy, ekskluzywne butiki, drogie hotele i przepiękne widoki sprawiają iż jest to miejsce, o którym zwykły zjadacz chleba może tylko pomarzyć. Nic zatem dziwnego iż nazwa Portofino została, i to nie raz, wybrana dla nowo wymyślanych drinków. W Internecie i fachowej literaturze występuje bardzo wiele nazw drinków o nazwie Portofino. Zaczniemy od tego chyba najbardziej eleganckiego przedstawionego światu przez Marthę Stewart.",
"Powstał w 1941 r. w Stanach Zjednoczonych, w barze, gdzie trzeba było sprzedać nadmiar piwa imbirowego. Nie jest on drinkiem Rosyjskim, a swoją nazwę zawdzięcza użytej w niej wódce (która Amerykanom kojarzy się z Rosją). Drink tradycyjnie podaje się w miedzianych kubkach. Moscow Mule idealnie nadaje się na upalne, letnie dni. Szybko gasi pragnienie.",
"Koktajl Vesper Martini jest niesamowitą wariacją klasycznego wytrawnego Martini, które zapisało się na filmowych kartach historii jako ulubiony drink Jamesa Bonda pod słynnym wstrząśnięte, nie zmieszane. Czym Vesper różni się od klasycznego Martini? Po pierwsze, w naszym koktajlu znajdziemy wódkę, a nie tylko gin (jak w przypadku Dry Martini). Drugą różnicą jest przygotowanie – Vesper Martini wstrząsamy w szejkerze, a nie tylko mieszamy.",
"Orang-a-tang to bijący pomarańczą i aromatami koktajl o bardzo przyjemnym smaku. Wódka, rum i cointreau idealnie łączą się w kieliszku z grenadyną, sokiem z pomarańczy oraz limonki. Koniecznie podajcie na kolejnej imprezie!",
"Gdy koktajl nazywa się jak wyspa na Florydzie, nie ma wyjścia, po prostu musi być dobry. Key West Cooler to połączenie wódki, malibu oraz soków z pomarańczy i żurawiny. Prosto ale i bardzo smacznie i aromatycznie. Jeśli marzą Wam się wakacje na Florydzie, to z tym koktajlem przeniesiecie się tam chociaż na chwilę.",
            "Jak sama nazwa wskazuje, Hard Lemonade to po prostu lemoniada z dużym kopem. Koktajl powstał w Nowym Jorku w 2004 roku i od tamtej pory cieszy i orzeźwia w gorące, letnie popołudnia. Jest to propozycja, która zasmakuje każdemu.",
"Zazwyczaj okazuje się że proste rozwiązania są najlepsze. Weźmy na przykład takie Black Russian (Czarny Rosjanin), prosty drink składający się tylko z dwóch składników. Są to czysta wódka i meksykański likier kawowy Kahlua zmieszane z lodem i podawane w niskim szkle.",
"Whisky Sour nie jest tylko drinkiem, to pewnego rodzaju filozofia. Souerem może być drink zrobiony w oparciu o jakikolwiek mocny alkohol. Tak więc do przygotowania można użyć wódkę, gin, rum, tequilę, dowolną whisky czy brandy. Można spotkać również sour na bazie miękkiego alkoholu. Bardzo popularne jest Amaretto Sour czy Melon Sour. Kluczowym dla smaku jest balans słodko kwaśny, który należy odpowiednio dostosować do użytego alkoholu. Za słodycz odpowiada cukier najlepiej pod postacią syropu. Za kwasowość sok limonowy, cytrynowy lub mieszanka obydwu.",
"Jest wiele historii opisujących powstanie Manhattanu. Najbardziej znana mówi o tym że koktajl ten został po raz pierwszy przygotowany podczas przyjęcia w Manhattan Club w 1874 roku. Zostało ono wyprawione przez Jennie Churchill, amerykańską matkę Winstona Churchilla, na cześć nowo wybranego gubernatora Samuela J. Tildena. Podobno w księgach klubu widnieje nazwa nowego koktajlu, ale nie ma potwierdzenia co do daty jego powstania, jak również brak jest nazwiska autora tej kompozycji.\n" +
        "\n" +
        "Receptura zapisana w 1887 roku mówi o użyciu trzech części wermutu do jednej części żytniej whiskey z dodatkiem likieru curacao lub maraschino oraz kilku daszy bittersa. Ta z 1906 roku zamienia już proporcjami whiskey i wermut, sugerując użycie dwa razy więcej tej pierwszej przy pozostawieniu dodatków w tej samej ilości. Mimo późniejszych prób jeszcze większego ograniczenia wermutu względem “żytniej”, obecnie spotykana receptura najbliższa jest tej z 1906 roku, choć częściej teraz spotkać można jako podstawę Bourbon.",
"Podstawowy przepis na tego drinka jest bardzo podobny do pierwszego w historii przepisu na koktajl, który opublikował amerykański periodyk The Balance and Columbian Repository w 1806 roku. Wspomniany najstarszy przepis był raczej ogólnikowy i brzmiał mniej więcej w ten sposób: „Koktajl to stymulujący likwor zrobiony z mocnego alkoholu dowolnego gatunku, cukru, wody i bitters”. Widać zatem, że przepis na bazowy Old Fashioned dosyć mocno trzyma się wytycznych z początku XIX wieku, jedynym odstępstwem jest tutaj dodatek skórki od cytryny. To jest też powód, dla którego drink ten ma taką a nie inną nazwę – jest najzwyczajniej w świecie staromodny. Co ciekawe zbitka Old Fashioned, kiedyś służyła do tworzenia nazw wielu, różnych drinków.",
"Mint Julep to jeden z bardziej znanych drinków na świecie, jednak, jak pisze w swojej książce Rob Chirico, „ Jeżeli o Freudzie więcej się mówi niż czyta, to o Mint Julep częściej się czyta niż pije. Pewna ankieta ujawniła, że 70% Amerykanów nigdy nie spróbowało Mint Julep.” Mint Julep jest flagowym koktajlem wyścigów konnych Kentucky Derby i przy tej okazji spożywany jest w półhurtowych ilościach. Mieszanka Bourbonu, cukru, wody i mięty leje się hektolitrami. Oczywiście, jak to zawsze bywa, sukces ma wielu ojców, tak więc prawo do wynalezienia Mint Julep rości sobie, poza Kentucky, Wirginia, w skład której oryginalnie wchodziło hrabstwo Bourbon. Na tym jeszcze nie koniec, za  ojczyznę przepisu na Mint Julep, uważane są przez swoich mieszkańców takie stany jak Pensylwania, Maryland, czy Missisipi. Historycznie słowo „julep” pochodzi z arabskiego „julab” i oznacza „wodę różaną”, a każdy napój skrywający niemiły smak lekarstw nazywano w ten sposób. Nie wiadomo skąd nazwa ta pojawiła się w Stanach Zjednoczonych i jakie konotacje posiada do arabskiego znaczenia – fakt, iż duża ilość mięty w koktajlu może swobodnie zamaskować kiepską jakość użytego alkoholu bazowego. Ponoć na początku Mint Julep przygotowywany był na bazie Brandy, dopiero z czasem pojawił się w towarzystwie tańszego Bourbonu",
"Rusty Nail to koktajl, który powstał w latach 40-tych na Hawajach. Do wykonania tego aromatycznego koktajlu potrzebujecie jedynie ulubionej szkockiej oraz drambuie. Połączenie o mocno wyczuwalnej whisky z nutami miodowo – ziołowymi. ",
"Zdania na temat nazwy tego drinka są bardzo podzielone. Jedni twierdzą , że słówko „opening” wskazuje na czas, kiedy koktajl jest podawany podczas przyjęcia. Inni uważają, że Nasz drink otwiera usta, plącze języki i uwalnia sekrety jego amatorów. Nie pomożemy Wam rozwiązać dylematu pochodzenia nazwy koktajlu „Opening Shot”, ale podpowiemy, że z pewnością musicie go spróbować. Jak opisalibyśmy charakter tego koktajlu? Może jako dosłodzoną wariację drinka „Manhattan”. Spróbujcie i przekonajcie się sami! Życzymy smacznego!",
"Old pal to wieczorny aperitiff skomponowany po raz pierwszy w latach 30. Wykonujemy go na bazie american bourbon whiskey, wermutu oraz campari. Szczególnie polecamy wielbicielom wytrawnych koktajli. ",
"Musimy wspomnieć od razu, że nie jest to koktajl dla wszystkich. Peat’s Dragon nie należy do słodkich, łatwo pijalnych drinków. Jeśli jednak lubicie te wytrawne, aromatyczne, a przede wszystkim nieoczywiste to koniecznie spróbujcie!",
"Ten słynny koktajl z 2005 roku został stworzony przez Sama Rossa w nowojorskim Milk&Honey. Połączenie szkockiej, imbiru, miodu i cytryny to idealna propozycja na chłodniejsze dni. Może nie uleczy, ale z pewnością umili Wam chwilę. Klasyczne połączenia zawsze się sprawdzają, dlatego jego popularność zupełnie nas nie dziwi. ",
"Koktajl dla wielbicieli szkockiej. Nie zasmakuje jednak każdemu. Klasyczny przepis z The Savoy Cocktail Book łączy w równych proporcjach whisky, słodki wermut, likier wiśniowy i sok z pomarańczy. Jednak jeśli w takim wydaniu nie do końca przypada Wam on do gustu spokojnie możecie dodać nieco więcej soku z pomarańczy."
        )

        val ingredients = arrayOf("40 ml wódki limonkowej\n" +
                "20 ml Cointreau\n" +
                "20 ml soku żurawinowego\n" +
                "20 ml soku z limonki",
            "60 ml czystej wódki\n" +
                    "20 ml soku z cytryny\n" +
                    "20 ml syropu cukrowego",
            "30 ml wódki\n" +
                    "30 ml białego rumu\n" +
                    "10 ml Cointreau\n" +
                    "30 ml soku pomarańczowego\n" +
                    "30 ml soku żurawinowego\n" +
                    "30 ml soku ananasowego\n" +
                    "20 ml soku z limonki\n" +
                    "10 ml syropu cukrowego",
"10 ml Campari\n" +
        "40 ml sok z czerwonych grejpfrutów\n" +
        "60 ml tonic",
            "50 ml wódki\n" +
                    "25 ml soku z limonki\n" +
                    "150 ml piwa imbirowego",
"20 ml czystej wódki\n" +
        "60 ml ginu\n" +
        "10 ml Lillet blanc",
"40 ml wódki\n" +
        "10 ml ciemnego rumu\n" +
        "20 ml Cointreau\n" +
        "80 ml soku pomarańczowego\n" +
        "20 ml soku z limonki\n" +
        "10 ml Grenadiny",
"40 ml wódki\n" +
        "40 ml likieru Malibu\n" +
        "60 ml soku pomarańczowego\n" +
        "60 ml soku żurawinowego",
            "40 ml wódki\n" +
                    "20 ml syropu cukrowego\n" +
                    "6 szt. mięty w listkach\n" +
                    "2 szt. limonki w ćwiartkach\n" +
                    "40 ml wody gazowanej",
"40 ml czystej wódki\n" +
        "20 ml likieru kawowego",
            "40 ml whisky\n" +
                    "20 ml soku cytrynowego\n" +
                    "10 ml syropu cukrowego",
"60 ml amerykańskiej bourbon whiskey\n" +
        "30 ml słodkiego wermutu\n" +
        "2 dashe angostury",
"60 ml amerykańskiej bourbon whiskey\n" +
        "10 ml syropu cukrowego\n" +
        "2 dashe angostury",
"2 gałązki mięty\n" +
        "20 ml likieru brzoskwiniowego\n" +
        "2 cząstki dojrzałej brzoskwini\n" +
        "60 ml koniak",
"60 ml Scotch Blended Whisky\n" +
        "30 ml Drambuie",
"40 ml amerykańskiej bourbon whiskey\n" +
        "20 ml słodkiego wermutu\n" +
        "10 ml grenadiny",
"30 ml American Bourbon Whiskey\n" +
        "30 ml wytrawnego wermutu\n" +
        "30 ml Campari",
"szkocka blended whisky – 40 ml\n" +
        "szkocka single malt whisky – 20 ml\n" +
        "Grand Marnier – 20 ml\n" +
        "Lillet Blanc – 20 ml\n" +
        "wermut wytrawny – 20 ml\n" +
        "czarny pieprz – 3 szczypty",
"whisky szkocka – 50 ml\n" +
        "sok cytrynowy – 30 ml\n" +
        "miód – 15 ml\n" +
        "cząstka imbiru",
"scotch blended whisky – 20ml\n" +
        "wermut słodki – 20ml\n" +
        "likier wiśniowy – 20ml\n" +
        "pomarańczowy sok – 20ml"
        )

        val recipes = arrayOf(
            "Zacznij od przygotowania kieliszka, w którym podasz koktajl. W celu schłodzenia wstaw go do zamrażarki na kilka minut lub wypełnij lodem i odstaw na czas przygotowania drinka. Do szejkera nasyp lodu, a następnie wlej do niego wszystkie składniki. Za pomocą jiggera lub miarki kuchennej odmierz odpowiednie ilości, co pozwoli Ci zachować prawidłową recepturę i balans smaku koktajlu. Całość energicznie wstrząśnij w szejkerze i za pomocą sitka barmańskiego odcedź do schłodzonego wcześniej kieliszka (bez lodu). Udekoruj koktajl za pomocą skórki z pomarańczy.\n" +
                    "\n" +
                    "Jeżeli nie masz w domu szejkera, zastąp go dużym słoikiem.  Do słoika nasyp lodu, wlej wszystkie składniki, dokładnie zakręć i energicznie wstrząśnij. Resztę kroków już znasz. Powodzenia!",
        "Do szejkera nasyp lodu, a następnie za pomocą jiggera lub miarki kuchennej dokładnie odmierz i wlej wszystkie składniki. Energicznie wstrząśnij i tak przygotowany koktajl za pomocą sitka barmańskiego odcedź do niskiego szkła. Jako dekoracji użyj ćwiartki pomarańczy oraz wisienki koktajlowej. I gotowe!\n" +
                "\n" +
                "Wskazówka: Jeżeli nie posiadasz w domu szejkera, możesz śmiało zastąpić go dużym słoikiem. Wypełnij słoik lodem, wlej odpowiednie ilości składników, dokładnie zakręć i wstrząśnij. Resztę kroków znasz z przepisu powyżej! Smacznego!",
    "Kieliszek, w którym podasz koktajl wstaw na kilka minut do zamrażarki lub wypełnij lodem i odstaw w celu schłodzenia. Do szejkera nasyp lodu, wlej odpowiednie ilości wódki, białego rumu, soku z pomarańczy oraz cointreau i energicznie wstrząśnij. Do odmierzenia składników użyj jiggera lub miarki kuchennej – pomoże Ci to zachować recepturę koktajlu, a co za tym idzie idealny smak. Przelej koktajl do schłodzonego kieliszka. Jako dekoracji użyj cząstkę pomarańczy. ",
"Wszystkie składniki komponować w kolejności w wysokiej szklance wypełnionej lodem. Delikatnie zamieszać. Dekorować kawałkiem grejpfruta.\n" +
        "\n" +
        "Powyższy przepis to kwintesencja gorzkich smaków. Na pewno wyborny, choć w naszym odczuciu bardziej można go zakwalifikować do koktajli bezalkoholowych.",
    "Przygotuj szkło, w którym podasz koktajl – wypełnij je lodem. Do szkła wlej wódkę i sok z limonki. Dodaj piwo imbirowe. Zamieszaj i udekoruj cząstką limonki.",
"Przygotuj kieliszek, w którym podasz koktajl – w celu schłodzenia wypełnij lodem i pozostaw na czas przygotowania drinka lub umieść w zamrażarce na kilka minut. Do przygotowanego szejkera z lodem wlej wszystkie składniki i wstrząśnij. W dokładnym odmierzeniu ilości składników koktajlu pomoże Ci jigger lub miarka kuchenna. Tak przygotowanego drinka za pomocą sitka barmańskiego odcedź do schłodzonego kieliszka. Ostatnim krokiem do koktajlu doskonałego jest garnish. Udekoruj drinka skórką z cytryny. Smacznego! Wskazówka: Jeżeli nie posiadasz w domu szejkera, nic straconego. Śmiało możesz zastąpić go dużym słoikiem. Wypełnij go lodem, dodaj składniki, dokładnie zakręć i wstrząśnij. Resztę kroków już znasz!",
"Przygotuj wysokie szkło i zanim rozpoczniesz komponowanie drinka schłódź go. Do szejkera wsyp kilka kostek lodu i wlej wódkę, cointreau, sok pomarańczowy, sok z limonki i grenadinę. Do odmierzenia składników możesz użyć jiggera lub miarki kuchennej. Wstrząśnij wszystkie składniki. Następnie przelej zawartość szejkera do schłodzonego szkła. Na końcu wlej rum i… gotowe!",
"Key West Cooler jest prosty nie tylko w składzie ale i w wykonaniu. Do przygotowania tego koktajlu nie potrzebujecie szejkera! Wystarczy do wysokiego szkła nasypać lodu i dodać wszystkie składniki bezpośrednio do niego. Następnie delikatnie zamieszajcie. Pozostał już tylko garnish. Jako dekoracji użyjcie cząstki limonki.. i gotowe!",
            "Hard Lemonade komponujemy bezpośrednio w wysokim szkle. Wygnieć limonkę i miętę w szklance, a następnie dodaj wódkę, syrop cukrowy oraz wodę gazowaną i zamieszaj z kruszonym lodem ",
"Black Russian (Czarny Rosjanin) stworzone zostało około roku 1950 przez barmana Gustave Tops pracującego w Hotelu Metropole w Brukseli. Ponoć jednym z ówczesnych Gości, a zarazem miłośnikiem Black Russia był ambasador Stanów Zjednoczonych Pearl Mesta. Ani Jego Ekscelencja Ambasador, ani prawdopodobnie sam autor receptury na Black Russian (Czarny Rosjanin) nie przypuszczali iż tak prosty drink stanie się ikoną rozpoznawalną na całym świecie. Chyba nie ma zarówno barmana jak i aficionado koktajli, którzy nie wiedzieliby jak przygotować Black Russian. Jak w przypadku wszystkich drinków, tak i w przypadku Black Russian (Czarny Rosjanin), dla powodzenia kompozycji istotne znaczenie ma odpowiedni dobór jakościowych składników. Mimo iż nazwa wskazuje aby użyć wódkę rosyjską, to jednak skupić się należy nie na pochodzeniu ale na jej jakości. Co do likieru kawowego to chyba przy dość obecnie niskiej cenie Kahlua nie ma co używać zamienników, które istotnie rzutują na smak, a wcale nie są tańsze. Ciekawą modyfikacją Black Russian (Czarny Rosjanin) jest podawanie jej w wersji mrożonej. W tym celu należy po za klasycznymi składnikami w ilości 40 ml wódka i 20 ml likier kawowy Kahlua dodać dwie kulki lodów czekoladowych i kilka kostek lodu. Dokładnie zmiksować do uzyskania jednolitej konsystencji i raczyć się siedząc na tarasie w upalne południe tak uzyskaną kompozycją. Dla tych, którzy potrzebują wyzwań, ciekawym pomysłem jest stworzenie własnego likieru kawowego. Może nie będzie tak pyszny jak oryginalna Kahlua, ale satysfakcja z własnoręcznie przygotowanego trunku na pewno zrekompensuje braki w smaku.",
"Bardzo popularnym jest również dodanie białka kurzego i kilka kropli Angostura Bitter. W tym wypadku należy bardzo mocno wstrząsnąć koktajl, tak żeby odpowiednio ubić białko. W tym celu często stosuje się przy tworzeniu Whisky Sour technikę przygotowywania zwaną „dry shake”. Metoda ta polega na wstrząśnięciu wszystkich składników bez lodu, a następnie powtórne wstrząśnięcie już z użyciem lodu. Metoda ta pozwala uzyskać bardzo ładnie wyglądającą Whisky Sour, z gruba pianką na powierzchni. Dodatkową zaletą użycia białka jest to iż drink zmienia swoją teksturę stając się bardziej jedwabisty na języku. Dla tych, którzy nie chcą lub nie mogą wykorzystać białka kurzego, alternatywą jest zalewa z ciecierzycy lub mniej naturalne spieniacze. W zależności od wykorzystanej whisky powinno się używać odpowiednich składników kwasowych. Inną mieszaninę lub czysty sok wykorzystamy do Whisky Sour na bazie bourbonu, inną do Whisky Sour na bazie szkockiej czy irlandzkiej whisky. Whisky Sour może też służyć jako baza do modyfikacji. Wystarczy w miejsce syropu cukrowego użyć dowolnego innego syropu smakowego, puree owocowego, likieru czy domowej roboty marmolady lub powideł. Bardzo dobrym jest Whisky Sour skomponowana z połączenia whisky, soku z cytryny i marmolady pomarańczowej. Można tutaj dodatkowo, dla podkręcenia pikanterii, dodać trochę cynamonu, kardamonu czy goździków. Również pyszna w smaku jest whisky Sour z dodatkiem konfitury różanej i anyżu.",
"Zamieszaj wszystkie składniki w szklanicy z lodem i odcedź do schłodzonego kieliszka. Jako dekorację użyj wisienkę koktajlową.",
"Sposób przygotowania:\n" +
        "Zamieszaj wszystkie składniki łyżką barmańską w szklance powoli dodając kolejne kostki lodu. Jako dekorację użyj wisienkę koktajlową i skórkę z pomarańczy.",
"Na dnie szejkera wygnieść pierwszą gałązkę mięty razem z brzoskwiniami. Dodać pozostałe składniki. Wstrząsnąć z lodem i odcedzić do miedzianego lub stalowego kubka wypełnionego kruszonym lodem. Do dekoracji użyć drugą gałązkę mięty.",
"Do niskiego szkła wrzuć kilka kostek lodu, a następnie wlej składniki i delikatnie zamieszaj. W zależności od preferencji możesz nieco zmienić proporcje. Nic trudnego, prawda?",
"Do szejkera nasyp lodu, a następnie za pomocą jiggera lub miarki kuchennej dokładnie odmierz i wlej wszystkie składniki. Energicznie wstrząśnij i tak przygotowany koktajl za pomocą sitka barmańskiego odcedź do niskiego szkła (bez lodu). Jako dekoracji użyj wisienki koktajlowej. I gotowe!\n" +
        "\n" +
        "Wskazówka: Jeżeli nie posiadasz w domu szejkera, możesz śmiało zastąpić go dużym słoikiem. Wypełnij słoik lodem, wlej odpowiednie ilości składników, dokładnie zakręć i wstrząśnij. Resztę kroków znasz z przepisu powyżej! Smacznego!",
"Zanim przejdziesz do wykonania koktajlu przygotuj kieliszek, w którym podasz swój koktajl. Wypełnij go lodem i odstaw na kilka minut lub wstaw do zamrażarki na czas przygotowywania drinka. Zamieszaj wszystkie składniki w szklanicy z lodem i odcedź do schłodzonego kieliszka. Czas na ostatni krok, czyli garnish! Dekoracją naszego koktajlu będzie skórka z pomarańczy.",
"Koktajl podajemy w schłodzonym szkle, dlatego zacznij od wypełnienia kieliszka lodem lub wstawienia go do zamrażarki na kilka minut, a następnie przygotuj szejker i wszystkie składniki. Do odmierzenia dokładnych ilości użyj jiggera lub miarki kuchennej. Do szejkera wypełnionego lodem wlej wszystkie składniki i energicznie wstrząśnij. Za pomocą sitka barmańskiego odcedź tak przygotowanego drinka do schłodzonego kieliszka (bez lodu).\n" +
        "\n" +
        "Podpowiedź: Szejker możesz zastąpić dużym słoikiem. Wsyp do niego lód, następnie wlej wszystkie składniki, dokładnie zakręć i wstrząśnij. Kolejne kroki powtarzaj tak samo, jak w przepisie powyżej.",
"Na dnie szejkera wygnieć świeży imbir do uzyskania soku. Następnie wrzuć kilka kostek lodu i wlej pozostałe składniki. Całość energicznie wstrząśnij i za pomocą sitka barmańskiego odcedź do niskiego szkła wypełnionego świeżym lodem. Smacznego!",
"Zacznij od przygotowania kieliszka, w którym podasz koktajl. W celu schłodzenia wstaw go do zamrażarki na kilka minut lub wypełnij lodem i odstaw na czas przygotowania drinka. Do szejkera nasyp lodu, a następnie za pomocą jiggera lub miarki kuchennej dokładnie odmierz i wlej wszystkie składniki. Energicznie wstrząśnij i tak przygotowany koktajl za pomocą sitka barmańskiego odcedź do schłodzonego kieliszka…i gotowe!\n" +
        "\n" +
        "Wskazówka: Jeżeli nie posiadasz w domu szejkera, możesz śmiało zastąpić go dużym słoikiem. Wypełnij słoik lodem, wlej odpowiednie ilości składników, dokładnie zakręć i wstrząśnij. Resztę kroków znasz z przepisu powyżej! Smacznego!"
            )

        for (i in 0..(cocktailsNum-1)){
            val cocktail = Cocktail()

            cocktail.name = names[i]
            cocktail.id = i
            cocktail.imageResourceId = photos[i]
            cocktail.description = desctiptions[i]
            cocktail.recipe = recipes[i]
            cocktail.ingredients = ingredients[i]
            listCocktails.add(cocktail)
        }
    }


}