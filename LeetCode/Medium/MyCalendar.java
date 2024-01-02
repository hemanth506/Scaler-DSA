import java.util.ArrayList;

public class MyCalendar {

  ArrayList<Pair> pairArr = new ArrayList<>();

  public boolean book(int start, int end) {
    for (int i = 0; i < pairArr.size(); i++) {
      if (pairArr.get(i).start < end && start < pairArr.get(i).end)
        return false;
    }

    pairArr.add(new Pair(start, end));
    return true;
  }
}

class Pair {
  int start;
  int end;

  Pair(int st, int end) {
    this.start = st;
    this.end = end;
  }
}

// null,true,true,false,false,true,false,true,true,true,false