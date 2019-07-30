import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;


public class SquadTest {
    @Before
    public void setUp() {

    }
    @After
    public void tearDown() {
        Squad.clearSquads();
    }
    @Test
    public void SquadInstantiatesCorrectly_true() {
        Squad damn = new Squad("damns",12,"damn people");
        assertTrue(damn instanceof Squad);
    }
    @Test
    public void getName_returnsNameOfSquad_Shooters() {
        Squad damn = new Squad("Shooters",1,"shoot");
        assertEquals("Shooters", damn.getName());
    }
    @Test
    public void getSize_returnsInteger_1() {
        Squad damn = new Squad("Shooters",1,"shoot");
        assertEquals(1,damn.getSize());
    }
    @Test
    public void getCause_returnsString_shoot() {
        Squad damn = new Squad("Shooters",1,"shoot");
        assertEquals("shoot",damn.getCause());
    }
    @Test
    public void getId_assignsUniqueId_1() {
        Squad damn = new Squad("Shooters",1,"shoot");
        assertEquals(1,damn.getId());
    }
    @Test
    public void getSquads_returnsAllSquadsCreated_ArrayList() {
        Squad damn = new Squad("Shooters",1,"shoot");
        assertTrue(Squad.getSquads().contains(damn));
    }
    @Test
    public void getHeroes_returnsListOfHeroes_List() {
        Squad damn = new Squad("Shooters",1,"shoot");
        Hero sam = new Hero("amos",1,"kichwa","umama",damn.getId());
        damn.addHero(sam);
        List<Hero> expected = new ArrayList<Hero>();
        expected.add(sam);
        assertEquals(expected.get(0),damn.getHeroes().get(0));
    }
    @Test
    public void addHero_AddsHeroes_true() {
        Squad damn = new Squad("Shooters",1,"shoot");
        Hero sam = new Hero("sam", 12, "humble", "Girls",damn.getId());
        damn.addHero(sam);
        assertTrue(damn.getHeroes().contains(sam));
    }
    @Test
    public void addHero_doesNotAddHeroesOnceSquadSizeIsExceeded_false() {
        Squad damn = new Squad("Shooters",1,"shoot");
        Hero sam = new Hero("sam", 12, "humble", "Girls",damn.getId());
        Hero victor = new Hero("vic",12,"brainiac","mainiacs",damn.getId());
        damn.addHero(sam);
        damn.addHero(victor);
        assertTrue(damn.getHeroes().contains(sam));
        assertFalse(damn.getHeroes().contains(victor));
    }
    @Test
    public void removeHero_removesSingleInstanceOfHero_false() {
        Squad damn = new Squad("Shooters",1,"shoot");
        Hero sam = new Hero("sam", 12, "humble", "Girls",damn.getId());
        Hero victor = new Hero("vic",10,"trees","air",damn.getId());
        damn.addHero(sam);
        damn.addHero(victor);
        damn.removeHero(victor);
        assertFalse(damn.getHeroes().contains(victor));
    }
    @Test
    public void removeHeroes_removesSingleInstanceOfHero_false() {
        Squad damn = new Squad("Shooters",2,"shoot");
        Hero sam = new Hero("sam", 12, "humble", "Girls",damn.getId());
        Hero victor = new Hero("vic",10,"trees","air",damn.getId());
        damn.addHero(sam);
        damn.addHero(victor);
        damn.removeHeroes();
        assertFalse(damn.getHeroes().contains(victor));
        assertFalse(damn.getHeroes().contains(sam));
    }
    @Test
    public void find_ReturnsAnInstanceOfSquad_Squad() {
        Squad damn = new Squad("Shooters",2,"shoot");
        assertEquals(damn,Squad.find(1));
    }
    @Test
    public void find_returnsCorrectHeroWhenMoreThanOneExists_Hero() {

        Squad another = new Squad("clit",21,"peke");
        assertEquals(another,Squad.find(2));
    }
}