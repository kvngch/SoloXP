package com.soloxp.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\nH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\fH\u00c6\u0003JK\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001J\t\u0010!\u001a\u00020\"H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0012R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006#"}, d2 = {"Lcom/soloxp/ui/viewmodel/OnboardingUiState;", "", "currentStep", "", "energyLevel", "selectedGoals", "", "Lcom/soloxp/domain/model/QuestCategory;", "availableTimeMinutes", "preferredTone", "Lcom/soloxp/domain/model/Tone;", "isComplete", "", "(IILjava/util/Set;ILcom/soloxp/domain/model/Tone;Z)V", "getAvailableTimeMinutes", "()I", "getCurrentStep", "getEnergyLevel", "()Z", "getPreferredTone", "()Lcom/soloxp/domain/model/Tone;", "getSelectedGoals", "()Ljava/util/Set;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "app_debug"})
public final class OnboardingUiState {
    private final int currentStep = 0;
    private final int energyLevel = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Set<com.soloxp.domain.model.QuestCategory> selectedGoals = null;
    private final int availableTimeMinutes = 0;
    @org.jetbrains.annotations.NotNull()
    private final com.soloxp.domain.model.Tone preferredTone = null;
    private final boolean isComplete = false;
    
    public OnboardingUiState(int currentStep, int energyLevel, @org.jetbrains.annotations.NotNull()
    java.util.Set<? extends com.soloxp.domain.model.QuestCategory> selectedGoals, int availableTimeMinutes, @org.jetbrains.annotations.NotNull()
    com.soloxp.domain.model.Tone preferredTone, boolean isComplete) {
        super();
    }
    
    public final int getCurrentStep() {
        return 0;
    }
    
    public final int getEnergyLevel() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Set<com.soloxp.domain.model.QuestCategory> getSelectedGoals() {
        return null;
    }
    
    public final int getAvailableTimeMinutes() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.soloxp.domain.model.Tone getPreferredTone() {
        return null;
    }
    
    public final boolean isComplete() {
        return false;
    }
    
    public OnboardingUiState() {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int component2() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Set<com.soloxp.domain.model.QuestCategory> component3() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.soloxp.domain.model.Tone component5() {
        return null;
    }
    
    public final boolean component6() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.soloxp.ui.viewmodel.OnboardingUiState copy(int currentStep, int energyLevel, @org.jetbrains.annotations.NotNull()
    java.util.Set<? extends com.soloxp.domain.model.QuestCategory> selectedGoals, int availableTimeMinutes, @org.jetbrains.annotations.NotNull()
    com.soloxp.domain.model.Tone preferredTone, boolean isComplete) {
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