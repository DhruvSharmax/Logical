package Cvent;

public class PrintPrimes {
	public static void main(String[] args) {
		int num = 100;
		printPrimes(num);
		//IntStream.range(2, num).forEach(i->IntStream.range(2, i/2).filter(j->i%j==0).forEach(System.out::print));
	}

	private static void printPrimes(int num) {
		boolean flag;
		for(int i = 2;i<=num;i++) {
			flag = true;
			for(int j = 2;j<=i/2;j++)
				if(i%j==0) flag = false;
			
			if(flag) System.out.print(i+" ");
		}
	}
	
}

/*
 * one user - multiple platforms - channels - videos
 * one user can have multiple video - multiple channels
 * response API - http codes, error incorrect body
 * database design
 */

/*
 * request API - POST /platforms @oneToMany  response - platformID 200 OK - error 409
 * POJO Platform - id, name, date
 * PUT List<Channels> /platforms/{id}
 * id: 1001
 * Channel: {
 * name: {Comedy,horror}
 * }		success. 200 Ok
 * Delete
 * Patch 
 * POST /channels @ManyToMany response - channelID 200 OK
 * POJO Channel - id, name, List<videos> List<Platforms>
 * POST /upload @OneToMany response - videoID 200 OK
 * POJO Video - id, name, timestamp, List<Channels> , type
 * 
 * CRUD operations
 * 
 * for exception handling: @ControllerAdvice with invalid requestBody
 * 
 * platform -
 * id primary key
 * name Varchar2
 * date Date
 * 
 * Channel -
 * id pk
 * name
 * Platform_id foreign key
 * 
 * Video -
 * pk
 * name
 * 
 * Video_Channels (joining)
 * video_id_pk - channel_id_pk
 * 
 */

