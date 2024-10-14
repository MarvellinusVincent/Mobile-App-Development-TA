package com.example.practicum12.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u0003H\'\u00a8\u0006\t"}, d2 = {"Lcom/example/practicum12/database/TicketDao;", "", "getTicket", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/practicum12/Ticket;", "id", "Ljava/util/UUID;", "getTickets", "", "app_debug"})
@androidx.room.Dao
public abstract interface TicketDao {
    
    @androidx.room.Query(value = "SELECT * FROM ticket")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.practicum12.Ticket>> getTickets();
    
    @androidx.room.Query(value = "SELECT * FROM ticket WHERE id = :id")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<com.example.practicum12.Ticket> getTicket(@org.jetbrains.annotations.NotNull
    java.util.UUID id);
}