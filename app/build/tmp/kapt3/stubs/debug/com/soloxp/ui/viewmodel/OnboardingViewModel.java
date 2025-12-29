package com.soloxp.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fJ\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0017R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001a"}, d2 = {"Lcom/soloxp/ui/viewmodel/OnboardingViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/soloxp/data/repository/SoloXpRepository;", "(Lcom/soloxp/data/repository/SoloXpRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/soloxp/ui/viewmodel/OnboardingUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "completeOnboarding", "", "onFinish", "Lkotlin/Function0;", "nextStep", "previousStep", "toggleGoal", "category", "Lcom/soloxp/domain/model/QuestCategory;", "updateAvailableTime", "minutes", "", "updateEnergyLevel", "level", "app_debug"})
public final class OnboardingViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.soloxp.data.repository.SoloXpRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.soloxp.ui.viewmodel.OnboardingUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.soloxp.ui.viewmodel.OnboardingUiState> uiState = null;
    
    public OnboardingViewModel(@org.jetbrains.annotations.NotNull()
    com.soloxp.data.repository.SoloXpRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.soloxp.ui.viewmodel.OnboardingUiState> getUiState() {
        return null;
    }
    
    public final void updateEnergyLevel(int level) {
    }
    
    public final void toggleGoal(@org.jetbrains.annotations.NotNull()
    com.soloxp.domain.model.QuestCategory category) {
    }
    
    public final void updateAvailableTime(int minutes) {
    }
    
    public final void completeOnboarding(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onFinish) {
    }
    
    public final void nextStep() {
    }
    
    public final void previousStep() {
    }
}