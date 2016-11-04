package net.sourceforge.mochadoom.daycycle;

import net.sourceforge.mochadoom.doom.DoomMain;

/**
 * Monsters' attributes during the day. State Pattern.
 * 
 * @author Franco Cruces
 *
 */
public class Day extends ADayPart {
	
	public Day(DoomMain<?,?> DM, Kronos aKronos) {
		super(DM, aKronos);
	}
	
	//TODO Replace with correct values and parameters.
	@Override
	public float getVampireDamageMultiplier() {
		// Example
		return 1;
	}

	@Override
	public float getWerewolfDamageMultiplier() {
		// Example
		return 1;
	}

	@Override
	public int getMyDuration() {
		switch (DM.gameskill){
		case sk_baby: return DaycycleConfig.baby_dayDuration;
		case sk_easy: return DaycycleConfig.easy_dayDuration;
		case sk_medium: return DaycycleConfig.medium_dayDuration;
		case sk_hard: return DaycycleConfig.hard_dayDuration;
		case sk_nightmare: return DaycycleConfig.nightmare_dayDuration;
		default: return -1;
		}
	}

	@Override
	public void changePart() {
		this.kronos.setDayPart(new Night(this.DM, this.kronos));
	}

	@Override
	public String startMessage(){
		return DaycycleConfig.day_startMessage;
	}
	
	@Override
	public String halfMessage(){
		return DaycycleConfig.day_halfMessage;
	}
	
	@Override
	public String almostOverMessage() {
		return DaycycleConfig.day_almostOverMessage;
	}
	
}