package com.example.pokemonapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.pokemonapp.entities.*;
import com.example.pokemonapp.repositories.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PokemonappApplication implements CommandLineRunner {

	@Autowired
	private DresseurRepository dresseurRepository;

	@Autowired
	private PokemonRepository pokemonRepository;

	@Autowired
	private BoosterRepository boosterRepository;

	public static void main(String[] args) {
		SpringApplication.run(PokemonappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (dresseurRepository.count() == 0) {

			// --- Création des dresseurs ---
			Dresseur sacha = new Dresseur(); sacha.setNom("Ketchum"); sacha.setPseudo("Sacha"); sacha.setNiveau(10);
			Dresseur ondine = new Dresseur(); ondine.setNom("Misty"); ondine.setPseudo("Ondine"); ondine.setNiveau(8);
			Dresseur pierre = new Dresseur(); pierre.setNom("Pierre"); pierre.setPseudo("Pierre"); pierre.setNiveau(12);

			dresseurRepository.saveAll(Arrays.asList(sacha, ondine, pierre));

			// --- Pokémon Eau ---
			Pokemon carapuce = new Pokemon(); carapuce.setNom("Carapuce"); carapuce.setType("Eau"); carapuce.setNiveau(14); carapuce.setAttaque(48); carapuce.setDefense(65); carapuce.setRarete("Peu Commune"); carapuce.setDresseur(ondine); carapuce.setImageUrl("http://localhost:8080/images/carapuce.png");
			Pokemon stari = new Pokemon(); stari.setNom("Stari"); stari.setType("Eau"); stari.setNiveau(13); stari.setAttaque(45); stari.setDefense(55); stari.setRarete("Commune"); stari.setDresseur(pierre); stari.setImageUrl("http://localhost:8080/images/stari.png");
			Pokemon magicarpe = new Pokemon(); magicarpe.setNom("Magicarpe"); magicarpe.setType("Eau"); magicarpe.setNiveau(10); magicarpe.setAttaque(10); magicarpe.setDefense(55); magicarpe.setRarete("Commune"); magicarpe.setDresseur(pierre); magicarpe.setImageUrl("http://localhost:8080/images/magicarpe.png");
			Pokemon tentacool = new Pokemon(); tentacool.setNom("Tentacool"); tentacool.setType("Eau"); tentacool.setNiveau(12); tentacool.setAttaque(40); tentacool.setDefense(50); tentacool.setRarete("Peu Commune"); tentacool.setDresseur(pierre); tentacool.setImageUrl("http://localhost:8080/images/tentacool.png");
			Pokemon barpau = new Pokemon(); barpau.setNom("Barpau"); barpau.setType("Eau"); barpau.setNiveau(11); barpau.setAttaque(35); barpau.setDefense(40); barpau.setRarete("Commune"); barpau.setDresseur(sacha); barpau.setImageUrl("http://localhost:8080/images/barpau.png");
			Pokemon krabby = new Pokemon(); krabby.setNom("Krabby"); krabby.setType("Eau"); krabby.setNiveau(12); krabby.setAttaque(50); krabby.setDefense(50); krabby.setRarete("Commune"); krabby.setDresseur(ondine); krabby.setImageUrl("http://localhost:8080/images/krabby.png");
			Pokemon flobio = new Pokemon(); flobio.setNom("Flobio"); flobio.setType("Eau"); flobio.setNiveau(13); flobio.setAttaque(52); flobio.setDefense(53); flobio.setRarete("Peu Commune"); flobio.setDresseur(pierre); flobio.setImageUrl("http://localhost:8080/images/flobio.png");
			Pokemon hypotrempe = new Pokemon(); hypotrempe.setNom("Hypotrempe"); hypotrempe.setType("Eau"); hypotrempe.setNiveau(10); hypotrempe.setAttaque(30); hypotrempe.setDefense(35); hypotrempe.setRarete("Commune"); hypotrempe.setDresseur(sacha); hypotrempe.setImageUrl("http://localhost:8080/images/hypotrempe.png");
			Pokemon coquiperl = new Pokemon(); coquiperl.setNom("Coquiperl"); coquiperl.setType("Eau"); coquiperl.setNiveau(14); coquiperl.setAttaque(55); coquiperl.setDefense(60); coquiperl.setRarete("Peu Commune"); coquiperl.setDresseur(pierre); coquiperl.setImageUrl("http://localhost:8080/images/coquiperl.png");
			Pokemon phione = new Pokemon(); phione.setNom("Phione"); phione.setType("Eau"); phione.setNiveau(15); phione.setAttaque(60); phione.setDefense(65); phione.setRarete("Rare"); phione.setDresseur(sacha); phione.setImageUrl("http://localhost:8080/images/phione.png");

			// --- Pokémon Feu ---
			Pokemon salameche = new Pokemon(); salameche.setNom("Salamèche"); salameche.setType("Feu"); salameche.setNiveau(13); salameche.setAttaque(52); salameche.setDefense(43); salameche.setRarete("Commune"); salameche.setDresseur(ondine); salameche.setImageUrl("http://localhost:8080/images/salameche.png");
			Pokemon goupix = new Pokemon(); goupix.setNom("Goupix"); goupix.setType("Feu"); goupix.setNiveau(12); goupix.setAttaque(50); goupix.setDefense(45); goupix.setRarete("Peu Commune"); goupix.setDresseur(pierre); goupix.setImageUrl("http://localhost:8080/images/goupix.png");
			Pokemon flamoutan = new Pokemon(); flamoutan.setNom("Flamoutan"); flamoutan.setType("Feu"); flamoutan.setNiveau(14); flamoutan.setAttaque(55); flamoutan.setDefense(50); flamoutan.setRarete("Rare"); flamoutan.setDresseur(sacha); flamoutan.setImageUrl("http://localhost:8080/images/flamoutan.png");
			Pokemon braisillon = new Pokemon(); braisillon.setNom("Braisillon"); braisillon.setType("Feu"); braisillon.setNiveau(11); braisillon.setAttaque(48); braisillon.setDefense(42); braisillon.setRarete("Commune"); braisillon.setDresseur(pierre); braisillon.setImageUrl("http://localhost:8080/images/braisillon.png");
			Pokemon caninos = new Pokemon(); caninos.setNom("Caninos"); caninos.setType("Feu"); caninos.setNiveau(12); caninos.setAttaque(55); caninos.setDefense(50); caninos.setRarete("Peu Commune"); caninos.setDresseur(pierre); caninos.setImageUrl("http://localhost:8080/images/caninos.png");
			Pokemon arcanin = new Pokemon(); arcanin.setNom("Arcanin"); arcanin.setType("Feu"); arcanin.setNiveau(15); arcanin.setAttaque(80); arcanin.setDefense(70); arcanin.setRarete("Rare"); arcanin.setDresseur(sacha); arcanin.setImageUrl("http://localhost:8080/images/arcanin.png");
			Pokemon ponchiot = new Pokemon(); ponchiot.setNom("Ponchiot"); ponchiot.setType("Feu"); ponchiot.setNiveau(10); ponchiot.setAttaque(40); ponchiot.setDefense(35); ponchiot.setRarete("Commune"); ponchiot.setDresseur(pierre); ponchiot.setImageUrl("http://localhost:8080/images/ponchiot.png");
			Pokemon galopa = new Pokemon(); galopa.setNom("Galopa"); galopa.setType("Feu"); galopa.setNiveau(14); galopa.setAttaque(90); galopa.setDefense(65); galopa.setRarete("Rare"); galopa.setDresseur(sacha); galopa.setImageUrl("http://localhost:8080/images/galopa.png");
			Pokemon salandit = new Pokemon(); salandit.setNom("Salandit"); salandit.setType("Feu"); salandit.setNiveau(12); salandit.setAttaque(48); salandit.setDefense(43); salandit.setRarete("Peu Commune"); salandit.setDresseur(pierre); salandit.setImageUrl("http://localhost:8080/images/salandit.png");
			Pokemon pyroli = new Pokemon(); pyroli.setNom("Pyroli"); pyroli.setType("Feu"); pyroli.setNiveau(13); pyroli.setAttaque(65); pyroli.setDefense(60); pyroli.setRarete("Rare"); pyroli.setDresseur(ondine); pyroli.setImageUrl("http://localhost:8080/images/pyroli.png");

			// --- Pokémon Électrik ---
			Pokemon pikachu = new Pokemon(); pikachu.setNom("Pikachu"); pikachu.setType("Électrik"); pikachu.setNiveau(15); pikachu.setAttaque(55); pikachu.setDefense(40); pikachu.setRarete("Rare"); pikachu.setDresseur(sacha); pikachu.setImageUrl("http://localhost:8080/images/pikachu.png");
			Pokemon voltorbe = new Pokemon(); voltorbe.setNom("Voltorbe"); voltorbe.setType("Électrik"); voltorbe.setNiveau(12); voltorbe.setAttaque(50); voltorbe.setDefense(55); voltorbe.setRarete("Peu Commune"); voltorbe.setDresseur(pierre); voltorbe.setImageUrl("http://localhost:8080/images/voltorbe.png");
			Pokemon elektek = new Pokemon(); elektek.setNom("Élekable"); elektek.setType("Électrik"); elektek.setNiveau(14); elektek.setAttaque(65); elektek.setDefense(60); elektek.setRarete("Rare"); elektek.setDresseur(pierre); elektek.setImageUrl("http://localhost:8080/images/elektek.png");
			Pokemon raichu = new Pokemon(); raichu.setNom("Raichu"); raichu.setType("Électrik"); raichu.setNiveau(16); raichu.setAttaque(90); raichu.setDefense(55); raichu.setRarete("Rare"); raichu.setDresseur(sacha); raichu.setImageUrl("http://localhost:8080/images/raichu.png");
			Pokemon elektrode = new Pokemon(); elektrode.setNom("Électrode"); elektrode.setType("Électrik"); elektrode.setNiveau(15); elektrode.setAttaque(80); elektrode.setDefense(70); elektrode.setRarete("Rare"); elektrode.setDresseur(ondine); elektrode.setImageUrl("http://localhost:8080/images/elektrode.png");
			Pokemon pachirisu = new Pokemon(); pachirisu.setNom("Pachirisu"); pachirisu.setType("Électrik"); pachirisu.setNiveau(12); pachirisu.setAttaque(50); pachirisu.setDefense(45); pachirisu.setRarete("Peu Commune"); pachirisu.setDresseur(pierre); pachirisu.setImageUrl("http://localhost:8080/images/pachirisu.png");
			Pokemon luxio = new Pokemon(); luxio.setNom("Luxio"); luxio.setType("Électrik"); luxio.setNiveau(13); luxio.setAttaque(60); luxio.setDefense(50); luxio.setRarete("Peu Commune"); luxio.setDresseur(pierre); luxio.setImageUrl("http://localhost:8080/images/luxio.png");
			Pokemon zeraora = new Pokemon(); zeraora.setNom("Zeraora"); zeraora.setType("Électrik"); zeraora.setNiveau(16); zeraora.setAttaque(100); zeraora.setDefense(70); zeraora.setRarete("Rare"); zeraora.setDresseur(sacha); zeraora.setImageUrl("http://localhost:8080/images/zeraora.png");
			Pokemon elecsprint  = new Pokemon(); elecsprint.setNom("elecsprint"); elecsprint.setType("Électrik"); elecsprint.setNiveau(14); elecsprint.setAttaque(75); elecsprint.setDefense(60); elecsprint.setRarete("Peu Commune"); elecsprint.setDresseur(pierre); elecsprint.setImageUrl("http://localhost:8080/images/elecsprint.png");
			Pokemon voltali = new Pokemon(); voltali.setNom("voltali"); voltali.setType("Électrik"); voltali.setNiveau(15); voltali.setAttaque(90); voltali.setDefense(55); voltali.setRarete("Rare"); voltali.setDresseur(ondine); voltali.setImageUrl("http://localhost:8080/images/voltali.png");

			// --- Pokémon Plante ---
			Pokemon bulbizarre = new Pokemon(); bulbizarre.setNom("Bulbizarre"); bulbizarre.setType("Plante"); bulbizarre.setNiveau(12); bulbizarre.setAttaque(49); bulbizarre.setDefense(49); bulbizarre.setRarete("Commune"); bulbizarre.setDresseur(sacha); bulbizarre.setImageUrl("http://localhost:8080/images/bulbizarre.png");
			Pokemon herbizarre = new Pokemon(); herbizarre.setNom("Herbizarre"); herbizarre.setType("Plante"); herbizarre.setNiveau(16); herbizarre.setAttaque(62); herbizarre.setDefense(63); herbizarre.setRarete("Peu Commune"); herbizarre.setDresseur(sacha); herbizarre.setImageUrl("http://localhost:8080/images/herbizarre.png");
			Pokemon mystherbe = new Pokemon(); mystherbe.setNom("Mystherbe"); mystherbe.setType("Plante"); mystherbe.setNiveau(13); mystherbe.setAttaque(50); mystherbe.setDefense(45); mystherbe.setRarete("Commune"); mystherbe.setDresseur(pierre); mystherbe.setImageUrl("http://localhost:8080/images/mystherbe.png");
			Pokemon rosalia = new Pokemon(); rosalia.setNom("Rosalia"); rosalia.setType("Plante"); rosalia.setNiveau(14); rosalia.setAttaque(55); rosalia.setDefense(50); rosalia.setRarete("Peu Commune"); rosalia.setDresseur(pierre); rosalia.setImageUrl("http://localhost:8080/images/rosalia.png");
			Pokemon jungko = new Pokemon(); jungko.setNom("Jungko"); jungko.setType("Plante"); jungko.setNiveau(15); jungko.setAttaque(70); jungko.setDefense(65); jungko.setRarete("Rare"); jungko.setDresseur(sacha); jungko.setImageUrl("http://localhost:8080/images/jungko.png");
			Pokemon ogrepon = new Pokemon(); ogrepon.setNom("Rousselette"); ogrepon.setType("Plante"); ogrepon.setNiveau(12); ogrepon.setAttaque(50); ogrepon.setDefense(50); ogrepon.setRarete("Commune"); ogrepon.setDresseur(pierre); ogrepon.setImageUrl("http://localhost:8080/images/ogrepon.png");
			Pokemon roserade = new Pokemon(); roserade.setNom("Roserade"); roserade.setType("Plante"); roserade.setNiveau(16); roserade.setAttaque(80); roserade.setDefense(70); roserade.setRarete("Rare"); roserade.setDresseur(ondine); roserade.setImageUrl("http://localhost:8080/images/roserade.png");
			Pokemon tropius = new Pokemon(); tropius.setNom("Tropius"); tropius.setType("Plante"); tropius.setNiveau(13); tropius.setAttaque(60); tropius.setDefense(55); tropius.setRarete("Peu Commune"); tropius.setDresseur(pierre); tropius.setImageUrl("http://localhost:8080/images/tropius.png");
			Pokemon florizarre = new Pokemon(); florizarre.setNom("florizarre"); florizarre.setType("Plante"); florizarre.setNiveau(14); florizarre.setAttaque(65); florizarre.setDefense(60); florizarre.setRarete("Peu Commune"); florizarre.setDresseur(pierre); florizarre.setImageUrl("http://localhost:8080/images/florizarre.png");
			Pokemon lombre = new Pokemon(); lombre.setNom("Lombre"); lombre.setType("Plante"); lombre.setNiveau(12); lombre.setAttaque(55); lombre.setDefense(50); lombre.setRarete("Commune"); lombre.setDresseur(sacha); lombre.setImageUrl("http://localhost:8080/images/lombre.png");

			// --- Pokémon Vol ---
			Pokemon roucool = new Pokemon(); roucool.setNom("Roucool"); roucool.setType("Vol"); roucool.setNiveau(10); roucool.setAttaque(45); roucool.setDefense(40); roucool.setRarete("Commune"); roucool.setDresseur(sacha); roucool.setImageUrl("http://localhost:8080/images/roucool.png");
			Pokemon piafabec = new Pokemon(); piafabec.setNom("Piafabec"); piafabec.setType("Vol"); piafabec.setNiveau(12); piafabec.setAttaque(50); piafabec.setDefense(45); piafabec.setRarete("Commune"); piafabec.setDresseur(pierre); piafabec.setImageUrl("http://localhost:8080/images/piafabec.png");
			Pokemon rapasdepic = new Pokemon(); rapasdepic.setNom("Rapasdepic"); rapasdepic.setType("Vol"); rapasdepic.setNiveau(14); rapasdepic.setAttaque(70); rapasdepic.setDefense(60); rapasdepic.setRarete("Rare"); rapasdepic.setDresseur(pierre); rapasdepic.setImageUrl("http://localhost:8080/images/rapasdepic.png");
			Pokemon hypnomade = new Pokemon(); hypnomade.setNom("Hypnomade"); hypnomade.setType("Vol"); hypnomade.setNiveau(13); hypnomade.setAttaque(60); hypnomade.setDefense(55); hypnomade.setRarete("Peu Commune"); hypnomade.setDresseur(sacha); hypnomade.setImageUrl("http://localhost:8080/images/hypnomade.png");
			Pokemon goélise = new Pokemon(); goélise.setNom("Goélise"); goélise.setType("Vol"); goélise.setNiveau(12); goélise.setAttaque(55); goélise.setDefense(50); goélise.setRarete("Commune"); goélise.setDresseur(pierre); goélise.setImageUrl("http://localhost:8080/images/goélise.png");
			Pokemon drattak = new Pokemon(); drattak.setNom("Drattak"); drattak.setType("Vol"); drattak.setNiveau(16); drattak.setAttaque(100); drattak.setDefense(80); drattak.setRarete("Rare"); drattak.setDresseur(ondine); drattak.setImageUrl("http://localhost:8080/images/drattak.png");
			Pokemon corboss = new Pokemon(); corboss.setNom("Corboss"); corboss.setType("Vol"); corboss.setNiveau(15); corboss.setAttaque(90); corboss.setDefense(70); corboss.setRarete("Rare"); corboss.setDresseur(pierre); corboss.setImageUrl("http://localhost:8080/images/corboss.png");
			Pokemon canarticho = new Pokemon(); canarticho.setNom("Canarticho"); canarticho.setType("Vol"); canarticho.setNiveau(13); canarticho.setAttaque(60); canarticho.setDefense(55); canarticho.setRarete("Peu Commune"); canarticho.setDresseur(pierre); canarticho.setImageUrl("http://localhost:8080/images/canarticho.png");
			Pokemon artikodin  = new Pokemon(); artikodin.setNom("Artikodin "); artikodin.setType("Vol"); artikodin.setNiveau(12); artikodin.setAttaque(55); artikodin.setDefense(50); artikodin.setRarete("Peu Commune"); artikodin.setDresseur(sacha); artikodin.setImageUrl("http://localhost:8080/images/artikodin.png");
			Pokemon altaria = new Pokemon(); altaria.setNom("Altaria"); altaria.setType("Vol"); altaria.setNiveau(14); altaria.setAttaque(75); altaria.setDefense(65); altaria.setRarete("Rare"); altaria.setDresseur(pierre); altaria.setImageUrl("http://localhost:8080/images/altaria.png");

			// --- Sauvegarde de tous les Pokémon ---
			List<Pokemon> pokemons = Arrays.asList(
					carapuce, stari, magicarpe, tentacool, barpau, krabby, flobio, hypotrempe, coquiperl, phione,
					salameche, goupix, flamoutan, braisillon, caninos, arcanin, ponchiot, galopa, salandit, pyroli,
					pikachu, voltorbe, elektek, raichu, elektrode, pachirisu, luxio, zeraora, elecsprint, voltali,
					bulbizarre, herbizarre, mystherbe, rosalia, jungko, ogrepon, roserade, tropius, florizarre, lombre,
					roucool, piafabec, rapasdepic, hypnomade, goélise, drattak, corboss, canarticho, artikodin, altaria
			);

			pokemonRepository.saveAll(pokemons);

			// --- Création des boosters par type ---
			Booster boosterEau = new Booster(); boosterEau.setDateOuverture(LocalDate.now()); boosterEau.setDresseur(pierre);
			boosterEau.setCartes(Arrays.asList(carapuce, stari, magicarpe, tentacool, barpau, krabby, flobio, hypotrempe, coquiperl, phione));
			boosterRepository.save(boosterEau);

			Booster boosterFeu = new Booster(); boosterFeu.setDateOuverture(LocalDate.now()); boosterFeu.setDresseur(pierre);
			boosterFeu.setCartes(Arrays.asList(salameche, goupix, flamoutan, braisillon, caninos, arcanin, ponchiot, galopa, salandit, pyroli));
			boosterRepository.save(boosterFeu);

			Booster boosterElectrik = new Booster(); boosterElectrik.setDateOuverture(LocalDate.now()); boosterElectrik.setDresseur(pierre);
			boosterElectrik.setCartes(Arrays.asList(pikachu, voltorbe, elektek, raichu, elektrode, pachirisu, luxio, zeraora, elecsprint, voltali));
			boosterRepository.save(boosterElectrik);

			Booster boosterPlante = new Booster(); boosterPlante.setDateOuverture(LocalDate.now()); boosterPlante.setDresseur(pierre);
			boosterPlante.setCartes(Arrays.asList(bulbizarre, herbizarre, mystherbe, rosalia, jungko, ogrepon, roserade, tropius, florizarre, lombre));
			boosterRepository.save(boosterPlante);

			Booster boosterVol = new Booster(); boosterVol.setDateOuverture(LocalDate.now()); boosterVol.setDresseur(pierre);
			boosterVol.setCartes(Arrays.asList(roucool, piafabec, rapasdepic, hypnomade, goélise, drattak, corboss, canarticho, artikodin, altaria));
			boosterRepository.save(boosterVol);

			System.out.println("Données initiales créées : 3 Dresseurs, 50 Pokémon et 5 Boosters avec 10 cartes chacun !");
		}
	}
}
