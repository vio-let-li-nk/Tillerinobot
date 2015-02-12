package tillerino.tillerinobot.lang;

import java.util.List;
import java.util.Random;

import org.tillerino.osuApiModel.Mods;
import org.tillerino.osuApiModel.OsuApiUser;

import tillerino.tillerinobot.BeatmapMeta;
import tillerino.tillerinobot.IRCBot.IRCBotUser;
import tillerino.tillerinobot.RecommendationsManager.Recommendation;

public class Default implements Language {

	@Override
	public String unknownBeatmap() {
		return "Maaf, saya tidak tahu beatmap tersebut. Ia mungkin baru, terlalu susah, belum dikemukakan, ataupun bukan mod standard osu.";
	}

	@Override
	public String internalException(String marker) {
		return "Alamak... Tillerino versi manusia mengacau pendawaian aku."
				+ " Jika dia tidak sedar, bolehkah anda [https://github.com/Tillerino/Tillerinobot/wiki/Contact beritahu dia]? (reference "
				+ marker + ")";
	}

	@Override
	public String externalException(String marker) {
		return "Apa terjadi ini? Pelayan osu hanya memberi saya gangguan. Bolehkah anda memberitahu saya maksudnya? 0011101001010000"
				+ " Tillerino versi manusia memberitahu aku, anda tidak perlu risau tentang apa-apa, dan kita hanya perlu mencuba sekali lagi. "
				+ " Jika memang kamu risau tentang perkara berikut, anda boleh [https://github.com/Tillerino/Tillerinobot/wiki/Contact memberitahu dia] tentang perkara ini. (reference "
				+ marker + ")";
	}

	@Override
	public String noInformationForModsShort() {
		return "Tiada data untuk mod yang diminta.";
	}

	@Override
	public void welcomeUser(IRCBotUser user, OsuApiUser apiUser, long inactiveTime) {
		if(inactiveTime < 60 * 1000) {
			user.message("beep boop");
		} else if(inactiveTime < 24 * 60 * 60 * 1000) {
			user.message("Selamat datang kembali, " + apiUser.getUserName() + ".");
		} else if(inactiveTime > 7l * 24 * 60 * 60 * 1000) {
			user.message(apiUser.getUserName() + "...");
			user.message("...adakah itu kamu? Wah, lamanya sudah!");
			user.message("Memang baguslah untuk berjumpa anda sekali lagi. Adakah anda berminat untuk aku mencadang lagu?");
		} else {
			String[] messages = {
					"Anda memang kelihatan hendak akan cadangan aku.",
					"Memang baik melihat anda! :)",
					"Manusia kegemaran aku. (Jangan memberitahu manusia yang lain!)",
					"Ah, ini adalah kejutan yang menyenangkan! ^.^",
					"I was hoping you'd show up. All the other humans are lame, but don't tell them I said that! :3",
					"what do you feel like doing today?",
			};
			
			Random random = new Random();
			
			String message = messages[random.nextInt(messages.length)];
			
			user.message(apiUser.getUserName() + ", " + message);
		}
	}

	@Override
	public String unknownCommand(String command) {
		return "unknown command \"" + command
				+ "\". Type !help if you need help!";
	}

	@Override
	public String noInformationForMods() {
		return "Sorry, I can't provide information for those mods at this time.";
	}

	@Override
	public String malformattedMods(String mods) {
		return "Those mods don't look right. Mods can be any combination of DT HR HD HT EZ NC FL SO NF. Combine them without any spaces or special chars. Example: !with HDHR, !with DTEZ";
	}

	@Override
	public String noLastSongInfo() {
		return "I don't remember you getting any song info...";
	}

	@Override
	public String tryWithMods() {
		return "Try this map with some mods!";
	}

	@Override
	public String tryWithMods(List<Mods> mods) {
		return "Try this map with " + Mods.toShortNamesContinuous(mods);
	}

	/**
	 * The user's IRC nick name could not be resolved to an osu user id. The
	 * message should suggest to contact @Tillerinobot or /u/Tillerino.
	 * 
	 * @param exceptionMarker
	 *            a marker to reference the created log entry. six or eight
	 *            characters.
	 * @param name
	 *            the irc nick which could not be resolved
	 * @return
	 */
	public String unresolvableName(String exceptionMarker, String name) {
		return "Your name is confusing me. Are you banned? If not, pls [https://github.com/Tillerino/Tillerinobot/wiki/Contact contact Tillerino]. (reference "
				+ exceptionMarker + ")";
	}

	@Override
	public String excuseForError() {
		return "I'm sorry, there was this beautiful sequence of ones and zeros and I got distracted. What did you want again?";
	}

	@Override
	public String complaint() {
		return "Your complaint has been filed. Tillerino will look into it when he can.";
	}

	@Override
	public void hug(final IRCBotUser user, OsuApiUser apiUser) {
		user.message("Come here, you!");
		user.action("hugs " + apiUser.getUserName());
	}

	@Override
	public String help() {
		return "Hi! I'm the robot who killed Tillerino and took over his account. Just kidding, but I do use the account a lot."
				+ " [https://twitter.com/Tillerinobot status and updates]"
				+ " - [https://github.com/Tillerino/Tillerinobot/wiki commands]"
				+ " - [http://ppaddict.tillerino.org/ ppaddict]"
				+ " - [https://github.com/Tillerino/Tillerinobot/wiki/Contact contact]";
	}

	@Override
	public String faq() {
		return "[https://github.com/Tillerino/Tillerinobot/wiki/FAQ Frequently asked questions]";
	}
	
	@Override
	public String featureRankRestricted(String feature, int minRank, OsuApiUser user) {
		return "Sorry, at this point " + feature + " is only available for players who have surpassed rank " + minRank + ".";
	}
	
	@Override
	public String mixedNomodAndMods() {
		return "What do you mean nomod with mods?";
	}
	
	@Override
	public String outOfRecommendations() {
		return "I've recommended everything that I can think of."
				+ " Try other recommendation options or use !reset. If you're not sure, check !help.";
	}

	@Override
	public String notRanked() {
		return "Looks like that beatmap is not ranked.";
	}

	@Override
	public void optionalCommentOnNP(IRCBotUser user,
			OsuApiUser apiUser, BeatmapMeta meta) {
		// regular Tillerino doesn't comment on this
	}

	@Override
	public void optionalCommentOnWith(IRCBotUser user, OsuApiUser apiUser,
			BeatmapMeta meta) {
		// regular Tillerino doesn't comment on this
	}

	@Override
	public void optionalCommentOnRecommendation(IRCBotUser user,
			OsuApiUser apiUser, Recommendation meta) {
		// regular Tillerino doesn't comment on this
	}
	
	@Override
	public boolean isChanged() {
		return false;
	}

	@Override
	public void setChanged(boolean changed) {
		
	}

	@Override
	public String invalidAccuracy(String acc) {
		return "Invalid accuracy: \"" + acc + "\"";
	}

	@Override
	public void optionalCommentOnLanguage(IRCBotUser user, OsuApiUser apiUser) {
		user.message("So you like me just the way I am :)");
	}

	@Override
	public String invalidChoice(String invalid, String choices) {
		return "I'm sorry, but \"" + invalid
				+ "\" does not compute. Try these: " + choices + "!";
	}

	@Override
	public String setFormat() {
		return "The syntax to set a parameter is !set option value. Try !help if you need more pointers.";
	}
}
