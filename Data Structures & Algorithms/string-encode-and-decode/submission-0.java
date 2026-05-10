class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty())return "";

        List<Integer> sizes=new ArrayList<>();
        for(int i=0;i<strs.size();i++){
            int size=strs.get(i).length();
            sizes.add(size);
        }

        StringBuilder out=new StringBuilder();
        for(int i=0;i<sizes.size();i++){
            out.append(sizes.get(i)).append(",");
        }
        out.append("#");
        for(String str:strs){
            out.append(str);
        }

        return out.toString();
    }

    public List<String> decode(String str) {
        if(str.length()==0)return new ArrayList<>();

        List<Integer> sizes=new ArrayList<>();
        List<String> decode=new ArrayList<>();

        int index=0;
        while(str.charAt(index)!='#'){
            StringBuilder curr=new StringBuilder();

            while(str.charAt(index)!=','){
                curr.append(str.charAt(index));
                index++;
            }

            sizes.add(Integer.parseInt(curr.toString()));
            index++;
        }

        index++; //skip #

        for(int i=0;i<sizes.size();i++){
            int size=sizes.get(i);

            String word=str.substring(index, index+size);
            decode.add(word);

            index+=size;
        }

        return decode;
    }
}
