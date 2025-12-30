package com.soloxp.domain.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b0\b\u0086\b\u0018\u00002\u00020\u0001B\u00b1\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\t\u00a2\u0006\u0002\u0010\u001bJ\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\u0007H\u00c6\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011H\u00c6\u0003J\t\u00107\u001a\u00020\u0007H\u00c6\u0003J\t\u00108\u001a\u00020\u0007H\u00c6\u0003J\t\u00109\u001a\u00020\tH\u00c6\u0003J\t\u0010:\u001a\u00020\u0019H\u00c6\u0003J\t\u0010;\u001a\u00020\tH\u00c6\u0003J\t\u0010<\u001a\u00020\u0005H\u00c6\u0003J\t\u0010=\u001a\u00020\u0007H\u00c6\u0003J\t\u0010>\u001a\u00020\tH\u00c6\u0003J\t\u0010?\u001a\u00020\u000bH\u00c6\u0003J\t\u0010@\u001a\u00020\u0007H\u00c6\u0003J\t\u0010A\u001a\u00020\u0007H\u00c6\u0003J\t\u0010B\u001a\u00020\u000fH\u00c6\u0003J\u000f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011H\u00c6\u0003J\u00b5\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00072\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\tH\u00c6\u0001J\u0013\u0010E\u001a\u00020\u00192\b\u0010F\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010G\u001a\u00020\u0007H\u00d6\u0001J\t\u0010H\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0015\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u001a\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0011\u0010\f\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0017\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0011\u0010\u0016\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001fR\u0011\u0010\r\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0011\u0010\u0018\u001a\u00020\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00101R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010!\u00a8\u0006I"}, d2 = {"Lcom/soloxp/domain/model/UserProfile;", "", "id", "", "tone", "Lcom/soloxp/domain/model/Tone;", "energyLevel", "", "xpTotal", "", "rank", "Lcom/soloxp/domain/model/Rank;", "fireCharges", "preferredTimePerDay", "activeTitle", "Lcom/soloxp/domain/model/Title;", "unlockedTitles", "", "skillPoints", "unlockedSkills", "Lcom/soloxp/domain/model/Skill;", "currentStreak", "longestStreak", "lastQuestCompletedDate", "streakSaverUsed", "", "dailyRitualCompletedDate", "(Ljava/lang/String;Lcom/soloxp/domain/model/Tone;IJLcom/soloxp/domain/model/Rank;IILcom/soloxp/domain/model/Title;Ljava/util/List;ILjava/util/List;IIJZJ)V", "getActiveTitle", "()Lcom/soloxp/domain/model/Title;", "getCurrentStreak", "()I", "getDailyRitualCompletedDate", "()J", "getEnergyLevel", "getFireCharges", "getId", "()Ljava/lang/String;", "getLastQuestCompletedDate", "getLongestStreak", "getPreferredTimePerDay", "getRank", "()Lcom/soloxp/domain/model/Rank;", "getSkillPoints", "getStreakSaverUsed", "()Z", "getTone", "()Lcom/soloxp/domain/model/Tone;", "getUnlockedSkills", "()Ljava/util/List;", "getUnlockedTitles", "getXpTotal", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class UserProfile {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final com.soloxp.domain.model.Tone tone = null;
    private final int energyLevel = 0;
    private final long xpTotal = 0L;
    @org.jetbrains.annotations.NotNull()
    private final com.soloxp.domain.model.Rank rank = null;
    private final int fireCharges = 0;
    private final int preferredTimePerDay = 0;
    @org.jetbrains.annotations.NotNull()
    private final com.soloxp.domain.model.Title activeTitle = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.soloxp.domain.model.Title> unlockedTitles = null;
    private final int skillPoints = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.soloxp.domain.model.Skill> unlockedSkills = null;
    private final int currentStreak = 0;
    private final int longestStreak = 0;
    private final long lastQuestCompletedDate = 0L;
    private final boolean streakSaverUsed = false;
    private final long dailyRitualCompletedDate = 0L;
    
    public UserProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    com.soloxp.domain.model.Tone tone, int energyLevel, long xpTotal, @org.jetbrains.annotations.NotNull()
    com.soloxp.domain.model.Rank rank, int fireCharges, int preferredTimePerDay, @org.jetbrains.annotations.NotNull()
    com.soloxp.domain.model.Title activeTitle, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.soloxp.domain.model.Title> unlockedTitles, int skillPoints, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.soloxp.domain.model.Skill> unlockedSkills, int currentStreak, int longestStreak, long lastQuestCompletedDate, boolean streakSaverUsed, long dailyRitualCompletedDate) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.soloxp.domain.model.Tone getTone() {
        return null;
    }
    
    public final int getEnergyLevel() {
        return 0;
    }
    
    public final long getXpTotal() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.soloxp.domain.model.Rank getRank() {
        return null;
    }
    
    public final int getFireCharges() {
        return 0;
    }
    
    public final int getPreferredTimePerDay() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.soloxp.domain.model.Title getActiveTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.soloxp.domain.model.Title> getUnlockedTitles() {
        return null;
    }
    
    public final int getSkillPoints() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.soloxp.domain.model.Skill> getUnlockedSkills() {
        return null;
    }
    
    public final int getCurrentStreak() {
        return 0;
    }
    
    public final int getLongestStreak() {
        return 0;
    }
    
    public final long getLastQuestCompletedDate() {
        return 0L;
    }
    
    public final boolean getStreakSaverUsed() {
        return false;
    }
    
    public final long getDailyRitualCompletedDate() {
        return 0L;
    }
    
    public UserProfile() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    public final int component10() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.soloxp.domain.model.Skill> component11() {
        return null;
    }
    
    public final int component12() {
        return 0;
    }
    
    public final int component13() {
        return 0;
    }
    
    public final long component14() {
        return 0L;
    }
    
    public final boolean component15() {
        return false;
    }
    
    public final long component16() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.soloxp.domain.model.Tone component2() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final long component4() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.soloxp.domain.model.Rank component5() {
        return null;
    }
    
    public final int component6() {
        return 0;
    }
    
    public final int component7() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.soloxp.domain.model.Title component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.soloxp.domain.model.Title> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.soloxp.domain.model.UserProfile copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    com.soloxp.domain.model.Tone tone, int energyLevel, long xpTotal, @org.jetbrains.annotations.NotNull()
    com.soloxp.domain.model.Rank rank, int fireCharges, int preferredTimePerDay, @org.jetbrains.annotations.NotNull()
    com.soloxp.domain.model.Title activeTitle, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.soloxp.domain.model.Title> unlockedTitles, int skillPoints, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.soloxp.domain.model.Skill> unlockedSkills, int currentStreak, int longestStreak, long lastQuestCompletedDate, boolean streakSaverUsed, long dailyRitualCompletedDate) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}