import java.util.ArrayList;
import java.util.List;

public class Office {
    public static void main(String[] args) {

        Room[] rooms = new Room[] {
                new Room("", 2),
                new Room("XXXXXX", 10),
                new Room("XXX", 2),
                new Room("XXXXXX", 8),
                new Room("X", 6)
        };

        System.out.println(meeting(rooms,2));

    }

    public static Object meeting(Room[] x, int need) {
        /*suggested solution
        if(need == 0)
            return "Game On";
        List<Integer> answer = new ArrayList<>();
        int taken;
        for(Room r: x){
            if(need > 0){
                taken = Math.max(0,r.chairs - r.occupants.length());
                answer.add(taken > need ? need : taken);
                need -= taken;
            }
            else
                break;
        }
        return need > 0 ? "Not enough!" : answer.stream().mapToInt(Integer::intValue).toArray();
    }*/
        List<Integer> chairsTaken = new ArrayList<>();
        if(need ==0){
            return "Game On";
        }else if (need <= 8 && need >0){
            for(int i=0; i<x.length;i++){
                //check how many chairs are left in each room
                int occupantNum = (x[i].occupants.length());
                int availableChair = x[i].chairs - occupantNum;
                System.out.println(availableChair);

                // check if the room has chairs for use
                if(availableChair <= 0 ){
                    chairsTaken.add(0);
                } else if (availableChair >  0){
                    if(availableChair > need){
                        chairsTaken.add(need);
                        need = 0;
                        break;
                    }
                    chairsTaken.add(availableChair);
                    need = need - availableChair;
                    if(need == 0){
                        break;
                    }

                }
            }
            if(need > 0 || need > 8 || chairsTaken.size() == 0 ){
                return "Not enough!";
            }
            System.out.println("taken chairs are" + chairsTaken);

        }
        int[] arr = new int[chairsTaken.size()];

        for(int i = 0; i < chairsTaken.size(); i++) {
            if (chairsTaken.get(i) != null) {
                arr[i] = chairsTaken.get(i);
            }
        }
        return arr;
    }
}

 class Room{
    public final String occupants;
    public final int chairs;

    public Room(String occupants, int chairs) {
        this.occupants = occupants;
        this.chairs = chairs;
    }

 }
