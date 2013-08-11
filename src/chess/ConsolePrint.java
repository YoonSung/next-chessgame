package chess;

import java.util.List;

public class ConsolePrint implements Showable {

	List<Rank> ranks;
	
	public ConsolePrint(List<Rank> ranks){
		this.ranks = ranks;
	}
	
	@Override
	public void generateBoard() {
		StringBuilder sb = new StringBuilder();
		for (int i = ROW_SIZE; i > 0; i--) {
			sb.append(generateRank(i-1) + NEW_LINE);
		}
		System.out.println(sb.toString());
	}

	private String generateRank(int rankIndex) {
		Rank rank = ranks.get(rankIndex);
		StringBuilder sb = new StringBuilder();
		sb.append(rank.generate());
		return sb.toString();
	}
}
