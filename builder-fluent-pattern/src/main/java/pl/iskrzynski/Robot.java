package pl.iskrzynski;

public final class Robot {
    private String head;
    private String arms;
    private String torso;
    private String legs;

    Robot(String aHead, String aArms, String aTorso, String aLegs) {
        head = aHead;
        arms = aArms;
        torso = aTorso;
        legs = aLegs;
    }

    String getHead() {
        return head;
    }

    String getArms() {
        return arms;
    }

    String getTorso() {
        return torso;
    }

    String getLegs() {
        return legs;
    }

    @Override
    public String toString() {
        return getHead() +"\n"+ getArms() +"\n"+ getTorso() +"\n"+ getLegs();
    }

    interface Head extends Creator{
        Arms setHead(String aHead);
    }

    interface Arms extends Creator {
        Torso setArms(String aArms);
    }

    interface Torso extends Creator {
        Legs setTorso(String aTorso);
    }

    interface Legs extends Creator{
        Creator setLegs(String aLegs);
    }

    interface Creator {
        Robot build();
    }


    public static class Builder implements Head, Arms, Torso, Legs, Creator {
        private String head;
        private String arms;
        private String torso;
        private String legs;

        private Builder() {
        }

        public static Head create() {
            return new Builder();
        }

        @Override
        public Arms setHead(String aHead) {
            this.head = aHead;
            return this;
        }

        @Override
        public Torso setArms(String aArms) {
            this.arms = aArms;
            return this;
        }

        @Override
        public Legs setTorso(String aTorso) {
            this.torso = aTorso;
            return this;
        }

        @Override
        public Creator setLegs(String aLegs) {
            this.legs = aLegs;
            return this;
        }

        @Override
        public Robot build() {
            if (this.head == null)
                this.head = "I don't have head '_'";

            if (this.arms == null)
                this.arms = "I don't have arms '_'";

            if (this.torso == null)
                this.torso = "I don't have torso '_'";

            if (this.legs == null)
                this.legs = "I don't have logs '_'";

            return new Robot(head, arms, torso, legs);
        }
    }
}
