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
    public void SquadInstatiatesCorrectly_true() {
        Squad damn = new Squad("damners",12,"damn people");
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
        Hero muchui = new Hero("amos",1,"kichwa","umama",damn.getId());
        damn.addHero(muchui);
        List<Hero> expected = new ArrayList<Hero>();
        expected.add(muchui);
        assertEquals(expected.get(0),damn.getHeroes().get(0));
    }
    @Test
    public void addHero_AddsHeroes_true() {
        Squad damn = new Squad("Shooters",1,"shoot");
        Hero muchui = new Hero("muchui", 12, "brainee", "Girls",damn.getId());
        damn.addHero(muchui);
        assertTrue(damn.getHeroes().contains(muchui));
    }
    @Test
    public void addHero_doesNotAddHeroesOnceSquadSizeIsExceeded_false() {
        Squad damn = new Squad("Shooters",1,"shoot");
        Hero muchui = new Hero("muchui", 12, "brainee", "Girls",damn.getId());
        Hero victor = new Hero("vic",12,"brainiac","mainiacs",damn.getId());
        damn.addHero(muchui);
        damn.addHero(victor);
        assertTrue(damn.getHeroes().contains(muchui));
        assertFalse(damn.getHeroes().contains(victor));
    }
    @Test
    public void removeHero_removesSingleInstanceOfHero_false() {
        Squad damn = new Squad("Shooters",1,"shoot");
        Hero muchui = new Hero("muchui", 12, "brainee", "Girls",damn.getId());
        Hero victor = new Hero("vic",10,"trees","air",damn.getId());
        damn.addHero(muchui);
        damn.addHero(victor);
        damn.removeHero(victor);
        assertFalse(damn.getHeroes().contains(victor));
    }
    @Test
    public void removeHeroes_removesSingleInstanceOfHero_false() {
        Squad damn = new Squad("Shooters",2,"shoot");
        Hero muchui = new Hero("muchui", 12, "brainee", "Girls",damn.getId());
        Hero victor = new Hero("vic",10,"trees","air",damn.getId());
        damn.addHero(muchui);
        damn.addHero(victor);
        damn.removeHeroes();
        assertFalse(damn.getHeroes().contains(victor));
        assertFalse(damn.getHeroes().contains(muchui));
    }
    @Test
    public void find_ReturnsAnInstanceOfSquad_Squad() {
        Squad damn = new Squad("Shooters",2,"shoot");
        assertEquals(damn,Squad.find(1));
    }
    @Test
    public void find_returnsCorrectHeroWhenMoreThanOneExists_Hero() {
        Squad damn = new Squad("Shooters",2,"shoot");
        Squad another = new Squad("Clit",21,"hoop cake");
        assertEquals(another,Squad.find(2));
    }
}