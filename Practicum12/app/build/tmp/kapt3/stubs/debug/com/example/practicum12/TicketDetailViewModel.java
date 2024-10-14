package com.example.practicum12;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/practicum12/TicketDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "ticketId", "Ljava/util/UUID;", "(Ljava/util/UUID;)V", "_ticket", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/practicum12/Ticket;", "ticket", "Lkotlinx/coroutines/flow/StateFlow;", "getTicket", "()Lkotlinx/coroutines/flow/StateFlow;", "ticketRepository", "Lcom/example/practicum12/TicketRepository;", "app_debug"})
public final class TicketDetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.practicum12.TicketRepository ticketRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.practicum12.Ticket> _ticket = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.practicum12.Ticket> ticket = null;
    
    public TicketDetailViewModel(@org.jetbrains.annotations.NotNull
    java.util.UUID ticketId) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.practicum12.Ticket> getTicket() {
        return null;
    }
}