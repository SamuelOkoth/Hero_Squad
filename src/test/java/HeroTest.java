import org.junit.Test;
import org.junit.After;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class HeroTest {

    @After
    public void tearDown() {
        Hero.clearAll();
    }
    @Test
    public void Hero_instatiatesCorrectly_true() {
        Squad testSquad = new Squad("awesome", 2,"eating pancakes");
        Hero testHero = new Hero("name", 12,"speed","sugar",testSquad.getId());
        assertTrue(testHero instanceof Hero);
    }
    @Test
    public void getName_returnsString_mario() {
        Squad testSquad = new Squad("awesome", 2,"eating pancakes");
        Hero testHero = new Hero("okoth", 12, "cooking","eating",testSquad.getId());
        assertEquals("okoth", testHero.getName());
    }
    @Test
    public void getAge_returnsInteger_12() {
        Squad testSquad = new Squad("awesome", 2,"eating pancakes");
        Hero testHero = new Hero("okoth", 12, "cooking","eating",testSquad.getId());
        assertEquals(12,testHero.getAge());
    }
    @Test
    public void getPower_returnsString_cooking() {
        Squad testSquad = new Squad("awesome", 2,"eating pancakes");
        Hero testHero = new Hero("okoth", 12, "cooking","eating",testSquad.getId());
        assertEquals("cooking",testHero.getPower());
    }
    @Test
    public void getWeakness_returnsString_eating() {
        Squad testSquad = new Squad("awesome", 2,"eating pancakes");
        Hero testHero = new Hero("okoth", 12, "cooking","eating",testSquad.getId());
        assertEquals("eating", testHero.getWeakness());
    }
    @Test
    public void getId_assignsUniqueId_int() {
        Squad testSquad = new Squad("awesome", 2,"eating pancakes");
        Hero testHero = new Hero("okoth", 12, "cooking","eating",testSquad.getId());
        assertEquals(1,testHero.getId());
    }
    @Test
    public void getSquadId_assignsEachHeroItsSquadId_int() {
        Squad testSquad = new Squad("awesome", 2,"eating pancakes");
        Hero testHero = new Hero("vic",12,"eating","showering",testSquad.getId());
        testSquad.addHero(testHero);
        assertEquals(testSquad.getId(),testHero.getSquadId());
    }
    @Test
    public void instances_containsHeroObjectsCreated_true() {
        Squad testSquad = new Squad("awesome", 2,"eating pancakes");
        Hero testHero = new Hero("mario", 12, "cooking","eating",testSquad.getId());
        Hero anotherTestHero = new Hero("Beryll",35,"drinking","men",testSquad.getId());
        assertTrue(Hero.getHeroes().contains(testHero));
        assertTrue(Hero.getHeroes().contains(anotherTestHero));
    }
    @Test
    public void getHeroes_returnsList_List() {
        Squad testSquad = new Squad("awesome", 2,"eating pancakes");
        Hero testHero = new Hero("mario", 12, "cooking","eating",testSquad.getId());
        List<Hero> expectedOutput = new ArrayList<Hero>();
        expectedOutput.add(testHero);
        assertEquals(expectedOutput.get(0), Hero.getHeroes().get(0));
    }
    @Test
    public void find_ReturnsAnInstanceOfHeroes_Hero() {
        Squad testSquad = new Squad("awesome", 2,"eating pancakes");
        Hero testHero = new Hero("sam",12,"eating","food",testSquad.getId());
        assertEquals(testHero,Hero.findHero(1));
    }
    @Test
    public void find_returnsCorrectHeroWhenMoreThanOneExists_Hero() {
        Squad testSquad = new Squad("awesome", 2,"eating pancakes");
        Hero testHero = new Hero("sam",12,"food","eating",testSquad.getId());
        Hero anotherTestHero = new Hero("Clit",21,"hoop","cake",testSquad.getId());
        assertTrue(testHero instanceof Hero);
        assertTrue(anotherTestHero instanceof Hero);
    }
}