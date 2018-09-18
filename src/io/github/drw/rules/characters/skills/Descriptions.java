/*
 * Descriptions.java
 *
 * Copyright (c) 2018 dr wilkinson <dr-wilkinson@users.noreply.github.com>.
 *
 * This file is part of Traveller.
 *
 * Traveller is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Traveller is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Traveller.  If not, see <http ://www.gnu.org/licenses/>.
 */
package io.github.drw.rules.characters.skills;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dr wilkinson <dr-wilkinson@users.noreply.github.com>
 */
public class Descriptions {

    private final static Map<Class<?>, String> descriptions = new HashMap<>();

    static {
        descriptions.put(ATVSkill.class, writeATVSkill());
        descriptions.put(AdminSkill.class, writeAdminSkill());
        descriptions.put(AirRaftSkill.class, writeAirRaftSkill());
        descriptions.put(BladeCombatSkill.class, writeBladeCombatSkill());
        descriptions.put(BladeSpecialism.class, writeBladeSpecialism());
        descriptions.put(BrawlingSkill.class, writeBrawlingSkill());
        descriptions.put(BriberySkill.class, writeBriberySkill());
        descriptions.put(ComputerSkill.class, writeComputerSkill());
        descriptions.put(ElectronicsSkill.class, writeElectronicsSkill());
        descriptions.put(EngineeringSkill.class, writeEngineeringSkill());
        descriptions.put(ForgerySkill.class, writeForgerySkill());
        descriptions.put(ForwardObserverSkill.class, writeForwardObserverSkill());
        descriptions.put(GamblingSkill.class, writeGamblingSkill());
        descriptions.put(GunCombatSkill.class, writeGunCombatSkill());
        descriptions.put(GunSpecialism.class, writeGunSpecialism());
        descriptions.put(GunnerySkill.class, writeGunnerySkill());
        descriptions.put(JOATSkill.class, writeJOATSkill());
        descriptions.put(LeaderSkill.class, writeLeaderSkill());
        descriptions.put(MechanicalSkill.class, writeMechanicalSkill());
        descriptions.put(MedicalSkill.class, writeMedicalSkill());
        descriptions.put(NavigationSkill.class, writeNavigationSkill());
        descriptions.put(PilotSkill.class, writePilotSkill());
        descriptions.put(ShipsBoatSkill.class, writeShipsBoatSkill());
        descriptions.put(StewardSkill.class, writeStewardSkill());
        descriptions.put(StreetwiseSkill.class, writeStreetwiseSkill());
        descriptions.put(TacticsSkill.class, writeTacticsSkill());
        descriptions.put(VacuumSuitSkill.class, writeVacuumSuitSkill());
    }

    public static String get(Class<?> clazz) {
        return descriptions.get(clazz);
    }

    private static String writeATVSkill() {
        StringBuilder sb = new StringBuilder();
        sb.append("The individual is acquainted with modern all-terrain vehicles and has been trained in or has experience with their operation. The term ATV (all terrain vehicle) includes AFV (armored fighting vehicle) within its meaning.");
        return sb.toString();
    }

    private static String writeAdminSkill() {
        StringBuilder sb = new StringBuilder();
        sb.append("The individual has had experience with bureaucratic agencies and understands the requirements of dealing with them and managing them.");
        return sb.toString();
    }

    private static String writeAirRaftSkill() {
        StringBuilder sb = new StringBuilder();
        sb.append("The individual has training and experience in the use and piloting of the air-raft or floater.");
        return sb.toString();
    }

    private static String writeBladeCombatSkill() {
        StringBuilder sb = new StringBuilder();
        sb.append("The individual is skilled in the use of a specific edged weapon in combat.");
        return sb.toString();
    }

    private static String writeBladeSpecialism() {
        StringBuilder sb = new StringBuilder();
        sb.append("The individual has experience in the combat use of the ");
        return sb.toString();
    }

    private static String writeBrawlingSkill() {
        StringBuilder sb = new StringBuilder();
        sb.append("Brawling is a general skill for hand-to-hand fighting. It includes the use of hands, clubs, bottles and the like, as weapons, conveying an initial expertise of 1 in each brawling weapon.");
        return sb.toString();
    }

    private static String writeBriberySkill() {
        StringBuilder sb = new StringBuilder();
        sb.append("The individual has experience in bribing petty and not-so-petty officials in order to circumvent regulations, or ignore cumbersome laws. (Bribery expertise does not guarantee success, but does minimize bad effects if the offer is rebuffed.)");
        return sb.toString();
    }

    private static String writeComputerSkill() {
        StringBuilder sb = new StringBuilder();
        sb.append("The individual is skilled in the programming and operation of electronic computers, both ground and ship based.");
        return sb.toString();
    }

    private static String writeElectronicsSkill() {
        StringBuilder sb = new StringBuilder();
        sb.append("The individual has skill in the use, operation and repair of electronic devices. The person is considered handy in this field, with the equivalent of green thumb talent. (This skill includes energy weapon repair.)");
        return sb.toString();
    }

    private static String writeEngineeringSkill() {
        StringBuilder sb = new StringBuilder();
        sb.append("The individual is skilled in the operation and maintenance of starship drives and power plants.");
        return sb.toString();
    }

    private static String writeForgerySkill() {
        StringBuilder sb = new StringBuilder();
        sb.append("The individual has a skill at faking documents and papers, sufficient to pass general inspection.");
        return sb.toString();
    }

    private static String writeForwardObserverSkill() {
        StringBuilder sb = new StringBuilder();
        sb.append("The individual has been trained (in military service) to call in and adjust artillery fire from distant batteries and from ships in orbit. Such fire may be projectile or energy beam in form.");
        return sb.toString();
    }

    private static String writeGamblingSkill() {
        StringBuilder sb = new StringBuilder();
        sb.append("The individual is well informed on games of chance, and wise in their play. He has an advantage over non-experts, and is generally capable of winning when he plays. (Gambling should not be confused with risk taking).");
        return sb.toString();
    }

    private static String writeGunCombatSkill() {
        StringBuilder sb = new StringBuilder();
        sb.append("The indivdual is skilled in the use of projectile and/or beam weapons in combat.");
        return sb.toString();
    }

    private static String writeGunSpecialism() {
        StringBuilder sb = new StringBuilder();
        sb.append("The individual has experience in the combat use of the ");
        return sb.toString();
    }

    private static String writeGunnerySkill() {
        StringBuilder sb = new StringBuilder();
        sb.append("The skill of gunnery is covered under weapons skills. The individual is trained and competent in the operation of weapons mounted on starships.");
        return sb.toString();
    }

    private static String writeJOATSkill() {
        StringBuilder sb = new StringBuilder();
        sb.append("The individual is proven capable of handling a wide variety of situations, and is resourceful in finding solutions and remedies.");
        return sb.toString();
    }

    private static String writeLeaderSkill() {
        StringBuilder sb = new StringBuilder();
        sb.append("The individual has led men in battle, or on adventures, and is possessed of the knowledge and self-assurance which will make for a capable emergent or appointed leader.");
        return sb.toString();
    }

    private static String writeMechanicalSkill() {
        StringBuilder sb = new StringBuilder();
        sb.append("The individual has skill in the use, operation and repair of mechanical devices. The person is considered to be handy in this field, with a talent similar to that of the green thumb in gardening. (This skill specifically excludes the field of engineering. It does include non-energy weapon repair.)");
        return sb.toString();
    }

    private static String writeMedicalSkill() {
        StringBuilder sb = new StringBuilder();
        sb.append("The individual has training in the medical arts and sciences.");
        return sb.toString();
    }

    private static String writeNavigationSkill() {
        StringBuilder sb = new StringBuilder();
        sb.append("The individual has training and expertise in the art and science of interplanetary and interstellar navigation.");
        return sb.toString();
    }

    private static String writePilotSkill() {
        StringBuilder sb = new StringBuilder();
        sb.append("The individual has training and experience in the operation of starships. (Pilot is independent of the skill Ship’s Boat which refers to interplanetary vessels.)");
        return sb.toString();
    }

    private static String writeShipsBoatSkill() {
        StringBuilder sb = new StringBuilder();
        sb.append("The individual is familiar with the function and operation of that class of spacecraft known as Ship's Boats, also referred to as shuttles or lifeboats.");
        return sb.toString();
    }

    private static String writeStewardSkill() {
        StringBuilder sb = new StringBuilder();
        sb.append("The individual is experienced and capable in the performance of the duties of a Ship’s Steward.");
        return sb.toString();
    }

    private static String writeStreetwiseSkill() {
        StringBuilder sb = new StringBuilder();
        sb.append("The individual is acquainted with the ways of local subcultures (which tend to be the same everywhere in human society), and thus is capable of dealing with strangers without alienating them. (This is not to be considered the same as alien contact, although the referee may so allow).");
        return sb.toString();
    }

    private static String writeTacticsSkill() {
        StringBuilder sb = new StringBuilder();
        sb.append("The individual has training and experience in small unit tactics (up to and including units of 1000 men), or individual spaceships. (This skill is not to be confused with strategy, which deals with the reasons for the encounter and the intended results of the encounter.)");
        return sb.toString();
    }

    private static String writeVacuumSuitSkill() {
        StringBuilder sb = new StringBuilder();
        sb.append("The individual has been trained, and has experience, in the use of standard vacuum suits (space suits), including armored battle dress and suits for use on various planetary surfaces in the presence of exotic, corrosive or insidious atmospheres.");
        return sb.toString();
    }

}
