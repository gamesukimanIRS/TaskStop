package cf.gamesukimanirs.taskstop;

//command
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.ConsoleCommandSender;
//base
import cn.nukkit.plugin.PluginBase;

public class Main extends PluginBase{

	private String PluginName = "TaskStop";
	private String version = "1.0.0";

	public void onEnable(){
		getLogger().info(PluginName + "-v" + version + "を読み込みました。作者:gamesukimanIRS");
    	getLogger().warning("製作者偽りと二次配布、友人用を除いた他人用の改造、改造配布、プラグインの横流し、悪用等はおやめ下さい。");
    	getLogger().warning("また、このプラグインを使用して発生した如何なる問題に対しての責任は負いかねます。");
    	getLogger().info("このプラグインを使用する際はどこかにプラグイン名「" + PluginName + "」と作者名「gamesukimanIRS」を記載して頂けると光栄です。");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equals("taskstop")) {
			if(!sender.isOp()) {
				sender.sendMessage("§a[TaskStop]§cエラー:001 このコマンドを実行する権限がありません。");
				return true;
			}
			if(!(sender instanceof ConsoleCommandSender)) {
				sender.sendMessage("§a[TaskStop]§cエラー:002 このコマンドはコンソールからのみ実行可能です。");
				return true;
			}
			try {
				if(args[0] == null) {
					sender.sendMessage("§a[TaskStop]§cエラー:003 タスクIDを入力するか、allで全てのタスクを指定してください。");
					return false;
				}
				if(args[0].equals("all")) {
					getServer().getScheduler().cancelAllTasks();
					sender.sendMessage("§a[TaskStop]§b全てのスケジューラータスクを停止しました。");
					return true;
				}else {
					try {
						int taskid = Integer.valueOf(args[0]);
						getServer().getScheduler().cancelTask(taskid);
						sender.sendMessage("§a[TaskStop]§b指定されたタスク(ID:"+args[0]+")を停止しました。");
						return true;
					}catch(NumberFormatException e) {
						sender.sendMessage("§a[TaskStop]§cエラー:004 入力されたIDは間違っています。正しいタスクIDを入力するか、allで全てのタスクを指定してください。");
						return false;
					}
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				sender.sendMessage("§a[TaskStop]§cエラー:003 タスクIDを入力するか、allで全てのタスクを指定してください。");
				return false;
			}
		}
		return true;
	}
}